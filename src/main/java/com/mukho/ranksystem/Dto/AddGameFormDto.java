package com.mukho.ranksystem.Dto;

public class AddGameFormDto {

	private String winUser;

	private String winRace;

	private String loseUser;

	private String loseRace;

	public AddGameFormDto() {

	}

	public AddGameFormDto(String winUser, String winRace, String loseUser, String loseRace) {
		this.winUser = winUser;
		this.winRace = winRace;
		this.loseUser = loseUser;
		this.loseRace = loseRace;
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

}
