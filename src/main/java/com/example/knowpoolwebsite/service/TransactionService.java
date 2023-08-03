package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.TransactionRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    List<TransactionResponse> getAllTransactions();

    TransactionResponse createTransaction(TransactionRequest transactionRequest);
    TransactionResponse updateTransaction(Integer id, TransactionRequest transactionRequest);

    void deleteTransaction(Integer id);
}
