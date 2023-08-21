package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.TransactionRequest;
import com.matrix.knowpoolwebsite.dto.response.TransactionResponseDto;

import java.util.List;

public interface TransactionService {
    List<TransactionResponseDto> getAllTransactions();

    TransactionResponseDto createTransaction(TransactionRequest transactionRequest);

    TransactionResponseDto updateTransaction(Integer id, TransactionRequest transactionRequest);

    void deleteTransaction(Integer id);
}
