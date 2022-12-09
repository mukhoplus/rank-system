package com.example.ranksystem.Entity;

public class AddGameForm {
    private String win_user;
    private String win_race;
    private String lose_user;
    private String lose_race;

    public String getWin_user() {
        return win_user;
    }

    public void setWin_user(String win_user) {
        this.win_user = win_user;
    }

    public String getWin_race() {
        return win_race;
    }

    public void setWin_race(String win_race) {
        this.win_race = win_race;
    }

    public String getLose_user() {
        return lose_user;
    }

    public void setLose_user(String lose_user) {
        this.lose_user = lose_user;
    }

    public String getLose_race() {
        return lose_race;
    }

    public void setLose_race(String lose_race) {
        this.lose_race = lose_race;
    }
}
