package com.mukho.ranksystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukho.ranksystem.Dto.RankDto;

@Repository
public interface RankingRepository extends CrudRepository<RankDto, Long> {

    @Query(value = "SELECT name, race, rating, wins, loses, ROUND(100. * wins/(wins+loses), 2) AS win_rate, " +
        "rank() OVER (ORDER BY rating DESC, 100. * wins/(wins+loses) DESC, wins DESC) AS rank_num " +
        "FROM gamer WHERE wins+loses > 0;", nativeQuery = true)
    List<RankDto> getRanking();

}
