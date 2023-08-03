package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
