package starter;

import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import starter.service.MessageServiceBot;

public class TelegramBot extends TelegramLongPollingBot {

    private final MessageServiceBot messageServiceBot;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public TelegramBot(MessageServiceBot messageServiceBot) {
        this.messageServiceBot = messageServiceBot;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            Message message1 = update.getMessage();
            if (message1 != null && message1.hasText()) {
                execute(messageServiceBot.inputMessage(message1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}