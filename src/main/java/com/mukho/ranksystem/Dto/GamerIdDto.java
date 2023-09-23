package com.mukho.ranksystem.Dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class GamerIdDto implements Serializable {

	private String name;

	private String race;

	public GamerIdDto() {

	}

	public GamerIdDto(String name, String race) {
		this.name = name;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
}
