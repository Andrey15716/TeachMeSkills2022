package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class MessageService {
    @Autowired
    private final ResponseService responseService;

    public MessageService(ResponseService responseService) {
        this.responseService = responseService;
    }

    public SendMessage inputMessage(Message message) {
        switch (message.getText()) {
            case ("/start"):
                return createMessage(message, "Welcome to chat with CityBot!");
            default:
                return createMessage(message, responseService.handleByCityName(message.getText()));
        }
    }

    private SendMessage createMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(text);
        return sendMessage;
    }
}
