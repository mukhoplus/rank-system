package com.example.ranksystem.repository;

import com.example.ranksystem.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsById(String id);
    User findById(String id);

}
