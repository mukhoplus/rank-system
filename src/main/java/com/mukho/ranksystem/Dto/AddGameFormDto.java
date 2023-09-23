package com.mukho.ranksystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddGameFormDto {

    private String win_user;

    private String win_race;

    private String lose_user;

    private String lose_race;

}
