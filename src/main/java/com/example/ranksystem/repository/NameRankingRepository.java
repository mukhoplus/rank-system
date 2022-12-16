package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.NameRank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRankingRepository extends CrudRepository<NameRank, Long> {

    @Query(value = "SELECT name, ROUND(AVG(rating)/1200*1000, 2) AS rating, SUM(wins) AS wins, SUM(loses) AS loses, ROUND(100. * SUM(wins)/(SUM(wins)+SUM(loses)), 2) AS win_rate, rank() OVER (ORDER BY AVG(rating) DESC, 100. * SUM(wins)/(SUM(wins)+SUM(loses)) DESC, SUM(wins) DESC) AS rank_num FROM gamer GROUP BY name HAVING SUM(wins)+SUM(loses) > 0;", nativeQuery = true)
    List<NameRank> getNameRanking();

}
