package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/r")
public class RecordController {

	private GameRepository gameRepository;
	private GamerRepository gamerRepository;

	@Autowired(required = false)
	public RecordController(GameRepository gameRepository, GamerRepository gamerRepository) {
		this.gameRepository = gameRepository;
		this.gamerRepository = gamerRepository;
	}

	@GetMapping(value = "/record")
	public ResponseEntity<List<List>> getRecord(@RequestParam(required = false) String name) throws IOException {
		List<List> records = new ArrayList<>();

		if (gamerRepository.existsByName(name)) {
			records.add(gamerRepository.getGamerRecordByRace(name, "Terran"));
			records.add(gamerRepository.getGamerRecordByRace(name, "Protoss"));
			records.add(gamerRepository.getGamerRecordByRace(name, "Zerg"));
		}

		return new ResponseEntity<>(records, HttpStatus.OK);
	}

	@GetMapping("/relative")
	public ResponseEntity<List<List>> getRelativeRecord(@RequestParam(required = false) String user1,
											 @RequestParam(required = false) String user2) {
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

		return new ResponseEntity<>(records, HttpStatus.OK);
	}

}