package com.mukho.ranksystem.Service;

import com.mukho.ranksystem.Dto.AddGameFormDto;
import com.mukho.ranksystem.Model.Game;

import java.util.List;

public interface GameService {

    List<Game> getGames();

    String addGame(AddGameFormDto form, String writer);

    int getRelative(String user1, String race1, String user2, String race2);

}
