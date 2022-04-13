package starter.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageServiceBot {

    public SendMessage inputMessage(Message message) {
        switch (message.getText()) {
            case ("/start"):
                return createMessage(message, "Welcome to chat with CityBot");
            default:
                return createMessage(message, "Hello!");
        }
    }

    public SendMessage createMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(text);
        return sendMessage;
    }
}
