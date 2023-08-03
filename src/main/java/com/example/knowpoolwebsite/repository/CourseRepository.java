package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course>findByStatus(String status);
    @Query(value = "select c from Course c")
    Page<Course> findAllPageable(Pageable pageable);
}
