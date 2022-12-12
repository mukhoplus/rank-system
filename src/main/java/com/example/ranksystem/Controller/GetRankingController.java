package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.Rank;
import com.example.ranksystem.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRankingController {

    private RankingRepository rankingRepository;

    @Autowired
    public GetRankingController(RankingRepository rankingRepository) { this.rankingRepository = rankingRepository; }

    /*
    전적이 있는 gamer 중,
        1. rating이 높은 순서
        2. 승률이 높은 순서
        3. 승이 많은 순서
     */
    @GetMapping(value="/ranking")
    List<Rank> getRanking(){
        return rankingRepository.getRanking();
    }
}
