package com.mukho.ranksystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_number")
	private int gameNumber;

	@Column(name = "win_user", length = 10)
	private String winUser;

	@Column(name = "win_race", length = 7)
	private String winRace;

	@Column(name = "lose_user", length = 10)
	private String loseUser;

	@Column(name = "lose_race", length = 7)
	private String loseRace;

	@Column(name = "point")
	private double point;

	@Column(name = "writer", length = 10)
	private String writer;

	public Game() {

	}

	public Game(String winUser, String winRace, String loseUser, String loseRace, double point, String writer) {
		this.winUser = winUser;
		this.winRace = winRace;
		this.loseUser = loseUser;
		this.loseRace = loseRace;
		this.point = point;
		this.writer = writer;
	}

	public Game(int gameNumber, String winUser, String winRace, String loseUser, String loseRace, double point,
		String writer) {
		this.gameNumber = gameNumber;
		this.winUser = winUser;
		this.winRace = winRace;
		this.loseUser = loseUser;
		this.loseRace = loseRace;
		this.point = point;
		this.writer = writer;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getWinUser() {
		return winUser;
	}

	public void setWinUser(String winUser) {
		this.winUser = winUser;
	}

	public String getWinRace() {
		return winRace;
	}

	public void setWinRace(String winRace) {
		this.winRace = winRace;
	}

	public String getLoseUser() {
		return loseUser;
	}

	public void setLoseUser(String loseUser) {
		this.loseUser = loseUser;
	}

	public String getLoseRace() {
		return loseRace;
	}

	public void setLoseRace(String loseRace) {
		this.loseRace = loseRace;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
