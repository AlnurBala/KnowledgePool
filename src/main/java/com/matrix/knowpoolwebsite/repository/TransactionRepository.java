package com.matrix.knowpoolwebsite.repository;

import com.matrix.knowpoolwebsite.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
