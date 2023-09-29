package com.mukho.ranksystem.Repository;

import com.mukho.ranksystem.Dto.Projection.UserInfoProjection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mukho.ranksystem.Model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u.id, u.name, u.permission FROM User u WHERE u.permission != 'master'", nativeQuery = true)
    List<UserInfoProjection> getUsers();

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET permission = ?2 WHERE id = ?1", nativeQuery = true)
    int updateUser(String id, String permission);

    boolean existsById(String id);

    User findById(String id);

}
