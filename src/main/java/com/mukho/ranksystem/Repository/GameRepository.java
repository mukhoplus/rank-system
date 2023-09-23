package com.mukho.ranksystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mukho.ranksystem.Model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

	@Query(value = "SELECT * FROM game ORDER BY game_number DESC;", nativeQuery = true)
	List<Game> getGames();

	@Query(value = "SELECT count(*) AS num FROM game where win_user = ?1 AND win_race = ?2 AND lose_user = ?3 AND lose_race = ?4 ;", nativeQuery = true)
	int getRelative(String user1, String race1, String user2, String race2);

}
