package pets.shalter.com.ahimals_shelter.service;

import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для обработки команд, получаемых от пользователей через Telegram-бота.
 *
 * Этот класс отвечает за интерпретацию входящих команд и соответствующую реакцию бота.
 * Команды обрабатываются с учетом текущего состояния взаимодействия с пользователем,
 * включая процесс регистрации.
 */
@Service
public class CommandHandlerService {

    @Autowired
    private TelegramMessageService messageService;

    @Autowired
    private RegistrationService registrationService;

    /**
     * Обрабатывает входящие команды от пользователя.
     *
     * @param update Обновление из Telegram, содержащее информацию о команде и чате.
     */
    public void handleCommand(Update update) {
        Long chatId = update.message().chat().id();
        String messageText = update.message().text();

        switch (messageText) {
            case "/start":
                messageService.sendMessage(chatId, "Hello! I can help you with shelters and adoption.");
                break;
            case "/info":
                messageService.sendMessage(chatId, "I provide information about shelters and adoption procedures.");
                break;
            case "/register":
                registrationService.startRegistration(chatId);
                break;
            case "/shelters":
                messageService.sendMessage(chatId, "Currently available shelter: 'Right to Life'\nAddress: пр. Тракторостроителей, 108г, Чебоксары\nPhone: 89530181715");
                break;
            case "/pet":
                messageService.sendPhoto(chatId, "https://push-dryg.ru/upload/iblock/fbb/1s0f11xjc03rcemgxglusjl8sv5qc49m/20231021_112341%202.jpg");
                messageService.sendMessage(chatId, "Gamma arrived at the shelter in 2018 with her puppies...");
                break;
            default:
                if (registrationService.isInRegistration(chatId)) {
                    registrationService.processRegistration(chatId, messageText);
                } else {
                    messageService.sendMessage(chatId, "Unknown command. Use /help to get started.");
                }
        }
    }
}
