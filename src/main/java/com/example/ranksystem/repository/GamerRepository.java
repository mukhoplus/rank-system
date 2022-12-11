package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Entity.GamerID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, GamerID> {

    boolean existsByName(String name);
    boolean existsByNameAndRace(String name, String race);
    Gamer findByName(String name);
    Gamer findByNameAndRace(String name, String race);

    @Query(value = "SELECT DISTINCT name FROM gamer ORDER BY name ASC;", nativeQuery = true)
    ArrayList<String> findNameList();

    @Transactional
    @Modifying
    @Query(value = "UPDATE gamer SET rating = ?3, wins = ?4 WHERE name = ?1 AND race = ?2 ;", nativeQuery = true)
    void save_w(String name, String race, double rating, int wins);

    @Transactional
    @Modifying
    @Query(value = "UPDATE gamer SET rating = ?3, loses = ?4 WHERE name = ?1 AND race = ?2 ;", nativeQuery = true)
    void save_l(String name, String race, double rating, int loses);
}
