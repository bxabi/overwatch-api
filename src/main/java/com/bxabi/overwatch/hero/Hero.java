package com.bxabi.overwatch.hero;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Hero {
	@Id
	private int id;

	private String name;
	private String real_name;
	private int health;
	private int armour;
	private int shield;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getReal_name() {
		return real_name;
	}

	public int getHealth() {
		return health;
	}

	public int getArmour() {
		return armour;
	}

	public int getShield() {
		return shield;
	}
}
