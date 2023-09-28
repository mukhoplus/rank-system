package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Repository.GamerRepository;
import com.mukho.ranksystem.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    private GameRepository gameRepository;
    private GamerRepository gamerRepository;

    @Autowired(required = false)
    public RecordServiceImpl(GameRepository gameRepository, GamerRepository gamerRepository) {
        this.gameRepository = gameRepository;
        this.gamerRepository = gamerRepository;
    }

    @Override
    public List<List> getRecord(String name) {
        List<List> records = new ArrayList<>();

        if (gamerRepository.existsByName(name)) {
            records.add(gamerRepository.getGamerRecordByRace(name, "Terran"));
            records.add(gamerRepository.getGamerRecordByRace(name, "Protoss"));
            records.add(gamerRepository.getGamerRecordByRace(name, "Zerg"));
        }

        return records;
    }

    @Override
    public List<List> getRelativeRecord(String user1, String user2) {
        List<List> records = new ArrayList<>();

        if (gamerRepository.existsByName(user1) && gamerRepository.existsByName(user2)) {
            String[] races = {"Terran", "Protoss", "Zerg"};
            for (String race1 : races) {
                for (String race2 : races) {
                    List record = new ArrayList<>();
                    record.add(gameRepository.getRelative(user1, race1, user2, race2));
                    record.add(gameRepository.getRelative(user2, race2, user1, race1));
                    records.add(record);
                }
            }
        }

        return records;
    }

}
