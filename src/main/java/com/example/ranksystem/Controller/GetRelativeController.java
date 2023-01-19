package com.example.ranksystem.Controller;

import com.example.ranksystem.repository.GameRepository;
import com.example.ranksystem.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetRelativeController {
    private GameRepository gameRepository;
    private GamerRepository gamerRepository;

    @Autowired(required = false)
    public GetRelativeController(GameRepository gameRepository, GamerRepository gamerRepository) {
        this.gameRepository = gameRepository;
        this.gamerRepository = gamerRepository;
    }

    @GetMapping("/getrelative")
    public ArrayList<ArrayList> record(@RequestParam(required = false) String user1, @RequestParam(required = false) String user2) {
        ArrayList<ArrayList> records = new ArrayList<>();

        if(gamerRepository.existsByName(user1) && gamerRepository.existsByName(user2)){
            String[] races = {"Terran", "Protoss", "Zerg"};
            for (String race1 : races) {
                for(String race2: races){
                    ArrayList record = new ArrayList<>();
                    record.add(gameRepository.getRelative(user1, race1, user2, race2));
                    record.add(gameRepository.getRelative(user2, race2, user1, race1));
                    records.add(record);
                }
            }
        }

        return records;
    }
}
