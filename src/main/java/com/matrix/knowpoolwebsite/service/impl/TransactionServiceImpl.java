package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.TransactionRequest;
import com.matrix.knowpoolwebsite.dto.response.TransactionResponseDto;
import com.matrix.knowpoolwebsite.entity.Transaction;
import com.matrix.knowpoolwebsite.mapper.TransactionMapper;
import com.matrix.knowpoolwebsite.repository.TransactionRepository;
import com.matrix.knowpoolwebsite.service.TransactionService;
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
    public List<TransactionResponseDto> getAllTransactions() {
        var transactionEntity = transactionRepository.findAll();
        return transactionMapper.toDTOs(transactionEntity);
    }
    @Override
    public TransactionResponseDto updateTransaction(Integer id, TransactionRequest transactionRequest) {
        var newTransaction = transactionRepository.findById(id).orElse(new Transaction());
        transactionMapper.mapUpdateRequestToEntity(newTransaction, transactionRequest);
        transactionRepository.save(newTransaction);
        return transactionMapper.toDTO(newTransaction);
    }

    @Override
    public TransactionResponseDto createTransaction(TransactionRequest transactionRequest) {
        var transactionEntity = transactionMapper.fromDTO(transactionRequest);
        transactionEntity = transactionRepository.save(transactionEntity);
        return transactionMapper.toDTO(transactionEntity);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}
