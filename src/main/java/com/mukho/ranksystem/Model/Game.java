package com.mukho.ranksystem.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

    public Game(String winUser, String winRace, String loseUser, String loseRace, double point, String writer){
        this.winUser = winUser;
        this.winRace = winRace;
        this.loseUser = loseUser;
        this.loseRace = loseRace;
        this.point = point;
        this.writer = writer;
    }

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

}
