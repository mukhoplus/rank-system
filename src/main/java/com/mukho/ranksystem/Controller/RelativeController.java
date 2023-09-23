package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Repository.GamerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("getrelative")
public class RelativeController {

	private GameRepository gameRepository;

	private GamerRepository gamerRepository;

	@Autowired(required = false)
	public RelativeController(GameRepository gameRepository, GamerRepository gamerRepository) {
		this.gameRepository = gameRepository;
		this.gamerRepository = gamerRepository;
	}

	@GetMapping
	public ResponseEntity<List<List>> record(@RequestParam(required = false) String user1,
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
