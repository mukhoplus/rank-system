package com.mukho.ranksystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.RankDto;
import com.mukho.ranksystem.Repository.RankingRepository;

@RestController
@RequestMapping("/ranking")
public class RankingController {

	private RankingRepository rankingRepository;

	public RankingController(RankingRepository rankingRepository) {
		this.rankingRepository = rankingRepository;
	}

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
