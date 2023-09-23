package com.mukho.ranksystem.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameRankDto {

    @Id
    private String name;

    private double rating = 1000.0;

    private int wins = 0;

    private int loses = 0;

    private double win_rate = 0;

    private int rank_num = 0;

}
