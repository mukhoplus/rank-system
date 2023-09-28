package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    

}
