package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Repository.GamerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/getgamers")
public class GetGamersController {

	private GamerRepository gamerRepository;

	@Autowired
	public GetGamersController(GamerRepository gamerRepository) {
		this.gamerRepository = gamerRepository;
	}

	@GetMapping
	public ResponseEntity<List> getGamers() {
		return new ResponseEntity<>(gamerRepository.findNameList(), HttpStatus.OK);
	}

}
