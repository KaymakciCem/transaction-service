package com.assignment.transaction.app.controller;

import com.assignment.transaction.app.dto.TransactionDto;
import com.assignment.transaction.app.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> getTransactions(@PathVariable("accountId") String accountId) {
        return transactionService.getTransactions(accountId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTransaction(@RequestBody TransactionDto transactionDto) {
        transactionService.addTransaction(transactionDto);
    }
}
