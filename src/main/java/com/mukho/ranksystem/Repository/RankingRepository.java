package com.mukho.ranksystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukho.ranksystem.Dto.RankDto;

@Repository
public interface RankingRepository extends CrudRepository<RankDto, Long> {

    @Query(value = "SELECT name, race, rating, wins, loses, ROUND(100.0 * win_ratio, 2) AS win_rate, " +
            "RANK() OVER (ORDER BY rating DESC, win_ratio DESC, wins DESC) AS rank_num FROM gamer " +
            "WHERE total_games > 0 OR (total_games = 0 AND rating != 1000.00);", nativeQuery = true)
    List<RankDto> getRanking();

}
