package com.bxabi.overwatch.ability;

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
public class AbilityController {

	@Autowired
	AbilityRepository abilities;

	@GetMapping("/api/abilities")
	public List<Ability> heros() {
		return abilities.findAll();
	}

	@GetMapping("/api/abilities/{ability_id}")
	public ResponseEntity<Ability> abilities(@PathVariable Integer ability_id) {
		Optional<Ability> ability = abilities.findById(ability_id);

		if (!ability.isPresent()) {
			throw new NotFoundException("Ability with id: " + ability_id + " not found.");
		}
		return new ResponseEntity<>(ability.get(), HttpStatus.OK);
	}

}
