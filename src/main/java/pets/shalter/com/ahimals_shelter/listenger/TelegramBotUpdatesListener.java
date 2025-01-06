package pets.shalter.com.ahimals_shelter.listenger;

import jakarta.annotation.PostConstruct;
import pets.shalter.com.ahimals_shelter.service.CommandHandlerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private CommandHandlerService commandHandlerService;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        try {
            for (Update update : updates) {
                logger.info("Processing update: {}", update);
                if (update.message() != null && update.message().text() != null) {
                    commandHandlerService.handleCommand(update);
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        } catch (Exception e) {
            logger.error("Error processing updates", e);
            return UpdatesListener.CONFIRMED_UPDATES_NONE;
        }
    }
}
