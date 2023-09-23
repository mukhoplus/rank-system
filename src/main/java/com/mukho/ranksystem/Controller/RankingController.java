package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Dto.RankDto;
import com.mukho.ranksystem.Repository.RankingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	private RankingRepository rankingRepository;

	/**
	 * 전적이 있는 gamer 중,
	 * 		1. rating이 높은 순서
	 * 		2. 승률이 높은 순서
	 * 		3. 승이 많은 순서
	 */
	@GetMapping
	public ResponseEntity<List<RankDto>> getRanking() {
		return new ResponseEntity<>(rankingRepository.getRanking(), HttpStatus.OK);
	}

}
