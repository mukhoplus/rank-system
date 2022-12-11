package com.example.ranksystem.Controller;

import com.example.ranksystem.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/getgamers")
public class GetGamersController {
    private GamerRepository gamerRepository;

    @Autowired
    public GetGamersController(GamerRepository gamerRepository){
        this.gamerRepository = gamerRepository;
    }

    @GetMapping()
    public ArrayList getGamers(){
        return gamerRepository.findNameList();
    }
}
