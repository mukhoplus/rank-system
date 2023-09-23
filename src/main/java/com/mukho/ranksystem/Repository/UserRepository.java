package com.mukho.ranksystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.mukho.ranksystem.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsById(String id);

    User findById(String id);

}
