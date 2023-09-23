package com.mukho.ranksystem.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

import com.mukho.ranksystem.Model.Gamer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(Gamer.class)
public class RankDto implements Serializable {

    @Id
    private String name;

    @Id
    private String race;

    private double rating = 1000.0;

    private int wins = 0;

    private int loses = 0;

    private double win_rate = 0;

    private int rank_num = 0;

}
