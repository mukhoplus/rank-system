package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Entity.GamerID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, GamerID> {

    boolean existsByName(String name);
    boolean existsByNameAndRace(String name, String race);
    Gamer findByName(String name);
    Gamer findByNameAndRace(String name, String race);

    @Query(value = "SELECT DISTINCT name FROM gamer ORDER BY name ASC;", nativeQuery = true)
    ArrayList<String> findNameList();

//    @Query(value = "UPDATE gamer SET rating = ?3, wins = ?4 WHERE name = ?1 AND race = ?2;")
//    Gamer save_w(String name, String race, double rating, int wins);
//
//    @Query(value = "UPDATE gamer SET rating = ?3, loses = ?4 WHERE name = ?1 AND race = ?2;")
//    Gamer save_l(String name, String race, double rating, int loses);
}
