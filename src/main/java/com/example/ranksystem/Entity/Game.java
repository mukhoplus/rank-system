package com.example.ranksystem.Entity;

import javax.persistence.*;

@Entity
public class Game {
    public Game(){

    }
    public Game(String win_user, String win_race, String lose_user, String lose_race, double point, String writer){
        this.win_user = win_user;
        this.win_race = win_race;
        this.lose_user = lose_user;
        this.lose_race = lose_race;
        this.point = point;
        this.writer = writer;
    }

    public int getGame_number() {
        return game_number;
    }

    public void setGame_number(int game_number) {
        this.game_number = game_number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_number")
    private int game_number;

    @Column(name = "win_user", length = 10)
    private String win_user;

    @Column(name = "win_race", length = 7)
    private String win_race;

    @Column(name = "lose_user", length = 10)
    private String lose_user;

    @Column(name = "lose_race", length = 7)
    private String lose_race;

    @Column(name = "point")
    private double point;

    @Column(name = "writer", length = 10)
    private String writer;

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
