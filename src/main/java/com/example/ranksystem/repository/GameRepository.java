package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

//    @Query(value = "INSERT INTO game VALUES(?1, ?2, ?3, ?4, ?5, ?6);")
//    Game save_g(String win_user, String win_race, String lose_user, String lose_race, double game_point, String writer);
}
