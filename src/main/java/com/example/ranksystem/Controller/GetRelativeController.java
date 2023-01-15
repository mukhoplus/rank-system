package com.example.ranksystem.Controller;

import com.example.ranksystem.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetRelativeController {
    private GameRepository gameRepository;

    @Autowired
    public GetRelativeController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping("/getrelative")
    public ArrayList<ArrayList> record(@RequestParam(required = false) String user1, @RequestParam(required = false) String user2) {
        ArrayList<ArrayList> records = new ArrayList<>();

        if(user1 != null && user2 != null){
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
