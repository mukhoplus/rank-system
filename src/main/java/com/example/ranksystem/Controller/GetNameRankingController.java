package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.NameRank;
import com.example.ranksystem.repository.NameRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetNameRankingController {

    private NameRankingRepository nameRankingRepository;

    @Autowired
    public GetNameRankingController(NameRankingRepository nameRankingRepository) { this.nameRankingRepository = nameRankingRepository; }

    /*
    전적이 있는 gamer 중,
        1. rating이 높은 순서
        2. 승률이 높은 순서
        3. 승이 많은 순서
     */
    @GetMapping(value="/getnameranking")
    List<NameRank> getNameRanking(){ return nameRankingRepository.getNameRanking(); }

}
