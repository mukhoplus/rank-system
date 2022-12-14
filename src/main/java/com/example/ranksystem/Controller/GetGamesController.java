package com.example.ranksystem.Controller;

import com.example.ranksystem.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/getgames")
public class GetGamesController {
    private GameRepository gameRepository;

    @Autowired
    public GetGamesController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping()
    public ArrayList getGames(){
        return gameRepository.getGames();
    }
}
