package com.mukho.ranksystem.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Gamer.class)
public class Gamer implements Serializable {

	@Id
	@Column(name = "name", length = 10)
	private String name;

	@Id
	@Column(name = "race", length = 7)
	private String race;

	@Column(name = "rating")
	private double rating = 1000.0;

	@Column(name = "wins")
	private int wins = 0;

	@Column(name = "loses")
	private int loses = 0;

	public Gamer() {

	}

	public Gamer(String name, String race) {
		this.name = name;
		this.race = race;
	}

	public Gamer(String name, String race, double rating, int wins, int loses) {
		this.name = name;
		this.race = race;
		this.rating = rating;
		this.wins = wins;
		this.loses = loses;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

}
