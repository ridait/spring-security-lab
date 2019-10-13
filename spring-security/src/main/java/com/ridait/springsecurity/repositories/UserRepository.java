package com.ridait.springsecurity.repositories;

import com.ridait.springsecurity.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findUserByUsername(String username);


    @Query("SELECT u FROM UserEntity u WHERE u.id = :userId")
    public UserEntity findUserById(@Param("userId") int id);
}
