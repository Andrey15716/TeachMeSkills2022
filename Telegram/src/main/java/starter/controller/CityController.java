package starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.model.City;
import starter.service.CityService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/addCity")
    public ResponseEntity addCity(@RequestBody City city) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.save(city));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/updateCity")
    public ResponseEntity updateCity(@RequestBody City city) {
        try {
            cityService.save(city);
            return ResponseEntity.status(HttpStatus.OK).body(cityService.save(city));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/cities")
    public List<City> listCities() {
        return cityService.findAll();
    }

    @GetMapping("/getCity/{id}")
    public ResponseEntity getCity(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.getCity(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity deleteCity(@PathVariable String id) {
        try {
            cityService.deleteCityById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}