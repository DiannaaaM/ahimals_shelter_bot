package pets.shalter.com.ahimals_shelter.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import com.pengrad.telegrambot.request.SetMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pets.shalter.com.ahimals_shelter.model.BotCommands;

@Configuration
public class BotConfig {

    @Value("${telegram.bot.token}")
    private String token;

    private final BotCommands botCommands;

    public BotConfig(BotCommands botCommands) {
        this.botCommands = botCommands;
    }

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        registerCommands(bot);
        return bot;
    }

    private void registerCommands(TelegramBot bot) {
        try {
            bot.execute(new SetMyCommands(
                    botCommands.getCommands().toArray(new BotCommand[0])
            ));
        } catch (Exception e) {
            System.err.println("Error registering commands: " + e.getMessage());
        }
    }
}
