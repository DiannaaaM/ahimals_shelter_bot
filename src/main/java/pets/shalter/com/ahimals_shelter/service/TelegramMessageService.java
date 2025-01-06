package pets.shalter.com.ahimals_shelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для отправки сообщений и фотографий пользователям в Telegram.
 *
 * Этот класс инкапсулирует логику отправки текстовых сообщений и изображений
 * через Telegram-бота, предоставляя простые методы для взаимодействия с пользователями.
 */
@Service
public class TelegramMessageService {

    @Autowired
    private TelegramBot telegramBot;

    /**
     * Отправляет текстовое сообщение указанному пользователю.
     *
     * @param chatId Уникальный идентификатор чата, куда будет отправлено сообщение.
     * @param message Текст сообщения для отправки.
     */
    public void sendMessage(Long chatId, String message) {
        telegramBot.execute(new SendMessage(chatId, message));
    }

    /**
     * Отправляет фотографию указанному пользователю.
     *
     * @param chatId Уникальный идентификатор чата, куда будет отправлена фотография.
     * @param photoUrl URL фотографии для отправки.
     */
    public void sendPhoto(Long chatId, String photoUrl) {
        telegramBot.execute(new SendPhoto(chatId, photoUrl));
    }
}
