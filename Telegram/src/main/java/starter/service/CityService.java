package starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.model.City;
import starter.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public Optional<City> findById(String city) {
        return cityRepository.findById(city);
    }

    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public City getCity(String id) {
        return cityRepository.findById(id).get();
    }

    public void deleteCityById(String id) {
        cityRepository.deleteById(id);
    }
}
