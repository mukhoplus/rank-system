package com.example.ranksystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(Gamer.class)
public class Rank  implements Serializable {
    public Rank(){

    }
    public Rank(String name, String race, double rating, int wins, int loses, double win_rate, int rank_num){
        this.name = name;
        this.race = race;
        this.rating = rating;
        this.wins = wins;
        this.loses = loses;
        this.win_rate = win_rate;
        this.rank_num = rank_num;
    }

    @Id
    private String name;
    @Id
    private String race;
    private double rating = 1200.0;
    private int wins = 0;
    private int loses = 0;
    private double win_rate = 0;
    private int rank_num = 0;

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

    public double getWin_rate() {
        return win_rate;
    }

    public void setWin_rate(double win_rate) {
        this.win_rate = win_rate;
    }

    public int getRank_num() {
        return rank_num;
    }

    public void setRank_num(int rank_num) {
        this.rank_num = rank_num;
    }
}
