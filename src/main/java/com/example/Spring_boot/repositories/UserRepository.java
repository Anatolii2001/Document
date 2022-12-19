package com.example.Spring_boot.repositories;

import com.example.Spring_boot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById (Long id);
}
