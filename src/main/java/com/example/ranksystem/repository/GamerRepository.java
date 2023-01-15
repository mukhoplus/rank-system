package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Entity.GamerID;
import com.example.ranksystem.Entity.NameRank;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Query(value = "SELECT name, race, SUM(wins) AS wins, SUM(loses) AS loses, ROUND(100. * SUM(wins)/(SUM(wins)+SUM(loses)), 2) AS win_rate, rating FROM gamer where name = ?1 AND race = ?2 ;", nativeQuery = true)
    ArrayList<Gamer> getGamerRecordByRace(String name, String race);

}
