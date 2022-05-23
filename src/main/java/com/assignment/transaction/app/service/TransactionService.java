package com.assignment.transaction.app.service;

import com.assignment.transaction.app.dto.TransactionDto;
import com.assignment.transaction.app.entity.Transaction;
import com.assignment.transaction.app.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public void addTransaction(final TransactionDto transactionData) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(transactionData.getAccountId());
        transaction.setAmount(transactionData.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);
    }

    public List<TransactionDto> getTransactions(final String accountId) {
        final List<Transaction> transactions = transactionRepository.findByAccountId(accountId);

        return transactions.stream()
                .map(c-> modelMapper.map(c, TransactionDto.class))
                .collect(Collectors.toUnmodifiableList());
    }
}
