package com.mukho.ranksystem.Repository;

import com.mukho.ranksystem.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsById(String id);

    User findById(String id);

}
