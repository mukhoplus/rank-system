package com.example.ranksystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(Gamer.class)
public class Gamer implements Serializable {
    public Gamer(){

    }
    public Gamer(String name, String race, double rating, int wins, int loses){
        this.name = name;
        this.race = race;
        this.rating = rating;
        this.wins = wins;
        this.loses = loses;
    }
    public Gamer(String name, String race){
        this.name = name;
        this.race = race;
    }

    @Id
    @Column(name = "name", length = 10)
    private String name;

    @Id
    @Column(name = "race", length = 7)
    private String race;

    @Column(name = "rating")
    private double rating = 1200.0;

    @Column(name = "wins")
    private int wins = 0;

    @Column(name = "loses")
    private int loses = 0;

    public void increaseWin(){
        this.wins++;
    }
    public void increaseLose(){
        this.loses++;
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

    public double calcRating(double myRating, double enemyRating, int isWin){
        return myRating + 20 * (isWin - calcEWR(myRating, enemyRating));
    }

    // Calculating expected winning rate
    public double calcEWR(double myRating, double enemyRating){
        return 1 / ( Math.pow(10, (enemyRating-myRating)/400) + 1);
    }
}
