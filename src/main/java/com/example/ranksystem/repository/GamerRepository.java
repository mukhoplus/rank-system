package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.Gamer;
import org.springframework.data.repository.CrudRepository;

public interface GamerRepository extends CrudRepository<Gamer, Long> {

    boolean existsByName(String name);
    Gamer findByName(String name);

}
