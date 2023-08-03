package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.TransactionRequest;
import com.example.knowpoolwebsite.dto.Response.TransactionResponse;
import com.example.knowpoolwebsite.entity.Transaction;
import com.example.knowpoolwebsite.mapper.TransactionMapper;
import com.example.knowpoolwebsite.repository.TransactionRepository;
import com.example.knowpoolwebsite.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionResponse> getAllTransactions() {
        var transactionEntity = transactionRepository.findAll();
        return transactionMapper.toDTOs(transactionEntity);
    }
    @Override
    public TransactionResponse updateTransaction(Integer id, TransactionRequest transactionRequest) {
        var newTransaction = transactionRepository.findById(id).orElse(new Transaction());
        transactionMapper.mapUpdateRequestToEntity(newTransaction, transactionRequest);
        transactionRepository.save(newTransaction);
        return transactionMapper.toDTO(newTransaction);
    }

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        var transactionEntity = transactionMapper.fromDTO(transactionRequest);
        transactionEntity = transactionRepository.save(transactionEntity);
        return transactionMapper.toDTO(transactionEntity);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}
