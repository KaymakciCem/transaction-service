package com.assignment.transaction.app.service;

import com.assignment.transaction.app.dto.TransactionDto;
import com.assignment.transaction.app.entity.Transaction;
import com.assignment.transaction.app.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    private static final String ACCOUNT_ID = "123";

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void addTransaction() {
        transactionService.addTransaction(getTransactionDto());

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);

        verify(transactionRepository).save(argument.capture());
        assertEquals("123", argument.getValue().getAccountId());
        assertEquals(BigDecimal.TEN, argument.getValue().getAmount());
    }

    private TransactionDto getTransactionDto() {
        TransactionDto obj = new TransactionDto();
        obj.setAmount(BigDecimal.TEN);
        obj.setAccountId(ACCOUNT_ID);

        return obj;
    }
}