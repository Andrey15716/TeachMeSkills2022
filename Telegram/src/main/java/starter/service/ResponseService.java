package starter.service;

import org.springframework.stereotype.Component;
import starter.model.City;

import java.util.Optional;

@Component
public class ResponseService {
    private final CityService cityService;

    public ResponseService(CityService cityService) {
        this.cityService = cityService;
    }

    public String handleByCityName(String cityName) {
        Optional<City> city = cityService.findById(cityName);
        return city.isPresent() ? city.get().getCaption() : "City not found";
    }
}
