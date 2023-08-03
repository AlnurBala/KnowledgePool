package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
