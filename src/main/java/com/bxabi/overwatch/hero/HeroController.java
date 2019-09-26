package com.bxabi.overwatch.hero;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bxabi.overwatch.NotFoundException;

@RestController
public class HeroController {

	@Autowired
	HeroRepository heroes;

	@GetMapping("/api/heros")
	public List<Hero> heros() {
		return heroes.findAll();
	}

	@GetMapping("/api/heros/{hero_id}")
	public ResponseEntity<Hero> heros(@PathVariable Integer hero_id) {
		Optional<Hero> hero = heroes.findById(hero_id);

		if (!hero.isPresent()) {
			throw new NotFoundException("Hero with id: " + hero_id + " not found.");
		}
		return new ResponseEntity<>(hero.get(), HttpStatus.OK);
	}

}
