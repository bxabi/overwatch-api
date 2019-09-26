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
	private Integer id;
	private String name;

	@Column(length = 1000)
	private String description;

	@JsonProperty("is_ultimate")
	private Boolean isUltimate;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Hero hero;

	public Ability() {
	}

	public Ability(Integer hero_id) {
		this.hero = new Hero(hero_id);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean isUltimate() {
		return isUltimate;
	}

	public Hero getHero() {
		return hero;
	}
}
