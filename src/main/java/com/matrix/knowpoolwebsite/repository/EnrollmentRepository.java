package com.matrix.knowpoolwebsite.repository;

import com.matrix.knowpoolwebsite.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
