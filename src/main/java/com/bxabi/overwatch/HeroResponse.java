package com.bxabi.overwatch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroResponse {
	private List<Hero> data;

	private int total;

	public Iterable<Hero> getHeroes() {
		return data;
	}

	public int getTotal() {
		return total;
	}

	public List<Hero> getData() {
		return data;
	}
}
