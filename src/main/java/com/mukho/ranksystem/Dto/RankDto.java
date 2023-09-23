package com.mukho.ranksystem.Dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.mukho.ranksystem.Model.Gamer;

@Entity
@IdClass(Gamer.class)
public class RankDto implements Serializable {

	@Id
	private String name;

	@Id
	private String race;

	private double rating = 1000.0;

	private int wins = 0;

	private int loses = 0;

	private double winRate = 0;

	private int rankNum = 0;

	public RankDto() {

	}

	public RankDto(String name, String race, double rating, int wins, int loses, double winRate, int rankNum) {
		this.name = name;
		this.race = race;
		this.rating = rating;
		this.wins = wins;
		this.loses = loses;
		this.winRate = winRate;
		this.rankNum = rankNum;
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

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public int getRankNum() {
		return rankNum;
	}

	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

}
