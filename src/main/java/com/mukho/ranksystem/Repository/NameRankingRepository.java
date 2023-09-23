package com.mukho.ranksystem.Repository;

import com.mukho.ranksystem.Dto.NameRankDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRankingRepository extends CrudRepository<NameRankDto, Long> {

    @Query(value = "SELECT name, ROUND(AVG(rating), 2) AS rating, SUM(wins) AS wins, SUM(loses) AS loses, ROUND(100. * SUM(wins)/(SUM(wins)+SUM(loses)), 2) AS win_rate, rank() OVER (ORDER BY AVG(rating) DESC, 100. * SUM(wins)/(SUM(wins)+SUM(loses)) DESC, SUM(wins) DESC) AS rank_num FROM gamer GROUP BY name HAVING SUM(wins)+SUM(loses) > 0;", nativeQuery = true)
    List<NameRankDto> getNameRanking();

}
