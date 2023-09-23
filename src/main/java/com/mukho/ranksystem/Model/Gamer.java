package com.mukho.ranksystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(Gamer.class)
public class Gamer implements Serializable {

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
    private double rating = 1000.0;

    @Column(name = "wins")
    private int wins = 0;

    @Column(name = "loses")
    private int loses = 0;

}
