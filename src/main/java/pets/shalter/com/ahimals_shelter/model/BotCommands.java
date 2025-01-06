package pets.shalter.com.ahimals_shelter.model;
import com.pengrad.telegrambot.model.BotCommand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BotCommands {

    public List<BotCommand> getCommands() {
        return List.of(
                new BotCommand("/start", "Start interacting with the bot"),
                new BotCommand("/info", "Get information about the bot"),
                new BotCommand("/register", "Register yourself"),
                new BotCommand("/shelters", "Get a list of shelters"),
                new BotCommand("/pet", "Get information about a specific pet")
        );
    }
}
