package com.mukho.ranksystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.NameRankDto;
import com.mukho.ranksystem.Repository.NameRankingRepository;

@RestController
@RequestMapping("/getnameranking")
public class NameRankingController {

	@Autowired
	private NameRankingRepository nameRankingRepository;

	/**
	 * 전적이 있는 gamer 중,
	 * 		1. rating이 높은 순서
	 * 		2. 승률이 높은 순서
	 * 		3. 승이 많은 순서
	 */
	@GetMapping
	public ResponseEntity<List<NameRankDto>> getNameRanking() {
		return new ResponseEntity<>(nameRankingRepository.getNameRanking(), HttpStatus.OK);
	}

}
