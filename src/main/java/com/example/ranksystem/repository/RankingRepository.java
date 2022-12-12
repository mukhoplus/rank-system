package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.GamerID;
import com.example.ranksystem.Entity.Rank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface RankingRepository extends CrudRepository<Rank, Long> {

    @Query(value = "SELECT name, race, rating, wins, loses, ROUND(100. * wins/(wins+loses), 2) AS win_rate, rank() OVER (ORDER BY rating DESC, 100. * wins/(wins+loses) DESC, wins DESC) AS rank_num FROM gamer WHERE wins+loses > 0;", nativeQuery = true)
    List<Rank> getRanking();

}
