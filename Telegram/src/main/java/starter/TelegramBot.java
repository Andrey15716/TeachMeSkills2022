package starter;

import lombok.Setter;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import starter.service.MessageService;

@Setter
public class TelegramBot extends TelegramLongPollingBot {

    private final MessageService messageService;
    private String token;
    private String username;

    public TelegramBot(DefaultBotOptions options, MessageService messageService) {
        super(options);
        this.messageService = messageService;
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            try {
                execute(messageService.inputMessage(message));
            } catch (TelegramApiException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}