package starter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import starter.TelegramBot;
import starter.model.City;
import starter.repository.CityRepository;
import starter.service.MessageService;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private MessageService messageService;
    @Value("${bot.botToken}")
    private String token;
    @Value("${bot.userName}")
    private String username;

    @PostConstruct
    private void registerBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            TelegramBot telegramBot = new TelegramBot(new DefaultBotOptions(), messageService);
            telegramBot.setUsername(username);
            telegramBot.setToken(token);
            botsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    @PostConstruct
    private void populateDb() {
        cityRepository.save(new City("Москва", "Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))"));
    }
}
