package com.bxabi.overwatch.hero;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroResponse {
	private List<Hero> data;

	public Iterable<Hero> getHeroes() {
		return data;
	}

	public List<Hero> getData() {
		return data;
	}
}
