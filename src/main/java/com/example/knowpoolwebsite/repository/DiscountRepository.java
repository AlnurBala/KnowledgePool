package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
//    Optional<Discount> findByCourseId(Integer courseId);
}
