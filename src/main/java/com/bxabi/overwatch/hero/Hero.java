package com.bxabi.overwatch.hero;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class Hero {
	@Id
	private Integer id;

	private String name;
	private String real_name;
	private Integer health;
	private Integer armour;
	private Integer shield;

	public Hero() {
	}

	public Hero(Integer hero_id) {
		id = hero_id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getReal_name() {
		return real_name;
	}

	public Integer getHealth() {
		return health;
	}

	public Integer getArmour() {
		return armour;
	}

	public Integer getShield() {
		return shield;
	}
}
