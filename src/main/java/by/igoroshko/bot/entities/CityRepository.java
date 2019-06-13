package by.igoroshko.bot.entities;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

	City findByName(String name);
}
