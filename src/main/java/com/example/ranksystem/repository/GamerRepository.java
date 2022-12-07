package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Entity.GamerID;
import org.springframework.data.repository.CrudRepository;

public interface GamerRepository extends CrudRepository<Gamer, GamerID> {

    boolean existsByName(String name);
    boolean existsByNameAndRace(String name, String race);
    Gamer findByName(String name);
    Gamer findByNameAndRace(String name, String race);

}
