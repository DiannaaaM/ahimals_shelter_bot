package pets.shalter.com.ahimals_shelter.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramMessageService {

    @Autowired
    private TelegramBot telegramBot;

    public void sendMessage(Long chatId, String message) {
        telegramBot.execute(new SendMessage(chatId, message));
    }

    public void sendPhoto(Long chatId, String photoUrl) {
        telegramBot.execute(new SendPhoto(chatId, photoUrl));
    }
}
