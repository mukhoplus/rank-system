package com.example.ranksystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NameRank {
    public NameRank(){

    }
    public NameRank(String name, double rating, int wins, int loses, double win_rate, int rank_num){
        this.name = name;
        this.rating = rating;
        this.wins = wins;
        this.loses = loses;
        this.win_rate = win_rate;
        this.rank_num = rank_num;
    }

    @Id
    private String name;
    private double rating = 1000.0;
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
