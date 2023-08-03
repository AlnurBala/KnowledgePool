package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.TransactionRequest;
import com.example.knowpoolwebsite.dto.Response.TransactionResponse;
import com.example.knowpoolwebsite.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
@Tag(name = "Transaction",description = "Transaction Management APIs")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public TransactionResponse createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }
    @PutMapping("/{id}")
    public TransactionResponse updateTransaction(@PathVariable Integer id, @RequestBody TransactionRequest transactionRequest){
        return transactionService.updateTransaction(id, transactionRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransactionById(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
    }
}
