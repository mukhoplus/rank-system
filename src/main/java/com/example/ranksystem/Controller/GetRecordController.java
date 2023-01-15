package com.example.ranksystem.Controller;

import com.example.ranksystem.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GetRecordController {
    private GamerRepository gamerRepository;

    @Autowired
    public GetRecordController(GamerRepository gamerRepository){
        this.gamerRepository = gamerRepository;
    }

    @GetMapping("/getrecord")
    public ArrayList<ArrayList> record(@RequestParam(required = false) String name) throws IOException{
        ArrayList<ArrayList> records = new ArrayList<>();

        if(gamerRepository.existsByName(name)){
            records.add(gamerRepository.getGamerRecordByRace(name, "Zerg"));
            records.add(gamerRepository.getGamerRecordByRace(name, "Protoss"));
            records.add(gamerRepository.getGamerRecordByRace(name, "Terran"));
        }

        return records;
    }
}
