package starter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import starter.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, String> {
}