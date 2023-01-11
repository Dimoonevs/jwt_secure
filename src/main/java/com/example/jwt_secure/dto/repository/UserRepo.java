package com.example.jwt_secure.dto.repository;

import com.example.jwt_secure.dto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
