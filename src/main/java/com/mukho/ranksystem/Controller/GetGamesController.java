package com.mukho.ranksystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Repository.GameRepository;

@RestController
@RequestMapping(value = "/getgames")
public class GetGamesController {

	private GameRepository gameRepository;

	@Autowired
	public GetGamesController(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@GetMapping
	public ResponseEntity<List> getGames() {
		return new ResponseEntity<>(gameRepository.getGames(), HttpStatus.OK);
	}

}
