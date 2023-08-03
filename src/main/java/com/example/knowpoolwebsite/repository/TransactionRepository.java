package com.example.knowpoolwebsite.repository;

import com.example.knowpoolwebsite.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
