package by.igoroshko.bot.controllers;

import by.igoroshko.bot.entities.City;
import by.igoroshko.bot.entities.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String saveOrUpdate(@RequestBody City city) {
		cityRepository.save(city);
		return "Saved";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody String deleteCity(@RequestBody City city) {
		cityRepository.delete(city);
		return "Deleted";
	}


}
