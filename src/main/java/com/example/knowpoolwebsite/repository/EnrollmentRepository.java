package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
