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
}
