package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Repository.GamerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getrecord")
public class RecordController {

	private GamerRepository gamerRepository;

	@Autowired
	public RecordController(GamerRepository gamerRepository) {
		this.gamerRepository = gamerRepository;
	}

	@GetMapping
	public ResponseEntity<List<List>> record(@RequestParam(required = false) String name) throws IOException {
		List<List> records = new ArrayList<>();

		if (gamerRepository.existsByName(name)) {
			records.add(gamerRepository.getGamerRecordByRace(name, "Terran"));
			records.add(gamerRepository.getGamerRecordByRace(name, "Protoss"));
			records.add(gamerRepository.getGamerRecordByRace(name, "Zerg"));
		}

		return new ResponseEntity<>(records, HttpStatus.OK);
	}

}
