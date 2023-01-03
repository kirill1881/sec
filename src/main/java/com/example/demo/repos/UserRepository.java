package com.example.demo.repos;

import com.example.demo.models.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Security, Long> {
    Security findSecurityByUsername(String username);
}
