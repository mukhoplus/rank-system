package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    @Query(value = "SELECT * FROM game ORDER BY game_number DESC;", nativeQuery = true)
    ArrayList<Game> getGames();

    @Query(value = "SELECT count(*) AS num FROM game where win_user = ?1 AND win_race = ?2 AND lose_user = ?3 AND lose_race = ?4 ;", nativeQuery = true)
    int getRelative(String user1, String race1, String user2, String race2);
}
