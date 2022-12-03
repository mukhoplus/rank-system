package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsById(String id);
    User findById(String id);

}
