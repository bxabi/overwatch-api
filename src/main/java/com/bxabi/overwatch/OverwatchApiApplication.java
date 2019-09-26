package com.bxabi.overwatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OverwatchApiApplication {

	@Autowired
	private HeroRepository heroes;

	@Autowired
	private AbilityRepository abilities;

	public static void main(String[] args) {
		SpringApplication.run(OverwatchApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	// maybe we need an earlier event here
	public void checkIfHeroDbExists() {
		if (heroes.count() == 0) {
			System.out.println("Hero database is not yet initialized");
			storeHeroes();
		}
		if (abilities.count() == 0) {
			System.out.println("Ability database is not yet initialized");
			storeAbilities();
		}
	}

	private void storeAbilities() {
		RestTemplate restTemplate;
		String url = "https://overwatch-api.net/api/v1/ability/";
		do {
			restTemplate = new RestTemplate();
			AbilityResponse abilityResponse = restTemplate.getForObject(url, AbilityResponse.class);

			abilities.saveAll(abilityResponse.getData());
			url = abilityResponse.getNext();
			if (url != null) {
				url = url.replace("http:/", "https:/");
			}
		} while (url != null);
		abilities.flush();

		System.out.println("Abilities retrieved and stored.");
	}

	private void storeHeroes() {
		RestTemplate restTemplate = new RestTemplate();
		HeroResponse heroResponse = restTemplate.getForObject("https://overwatch-api.net/api/v1/hero/",
				HeroResponse.class);

		heroes.saveAll(heroResponse.getHeroes());
		heroes.flush();
		System.out.println("Heroes retrieved and stored.");
	}

}
