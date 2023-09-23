package com.mukho.ranksystem.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NameRankDto {

	@Id
	private String name;

	private double rating = 1000.0;

	private int wins = 0;

	private int loses = 0;

	private double winRate = 0;

	private int rankNum = 0;

	public NameRankDto() {

	}

	public NameRankDto(String name, double rating, int wins, int loses, double winRate, int rankNum) {
		this.name = name;
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
