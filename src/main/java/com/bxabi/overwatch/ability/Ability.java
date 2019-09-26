package com.bxabi.overwatch.ability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bxabi.overwatch.hero.Hero;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class Ability {

	@Id
	private int id;
	private String name;

	@Column(length = 1000)
	private String description;

	@JsonProperty("is_ultimate")
	private boolean isUltimate;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Hero hero;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isUltimate() {
		return isUltimate;
	}

	public Hero getHero() {
		return hero;
	}
}
