package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByUsername(@Param("username") String username);
    User getUserByEmail(@Param("email") String email);
}