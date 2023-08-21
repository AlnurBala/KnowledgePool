package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.TransactionRequest;
import com.matrix.knowpoolwebsite.dto.response.TransactionResponseDto;
import com.matrix.knowpoolwebsite.service.TransactionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "Transaction", description = "Transaction Management APIs")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponseDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public TransactionResponseDto createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }

    @PutMapping("/{id}")
    public TransactionResponseDto updateTransaction(@PathVariable Integer id, @RequestBody TransactionRequest transactionRequest) {
        return transactionService.updateTransaction(id, transactionRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransactionById(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
    }
}
