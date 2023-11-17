package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Transaction;

import java.time.Instant;

public record TransactionRecord(
        Long transactionId,
        Long userId,
        Long orderId,
        Float amount,
        String status,
        Boolean expired,
        Instant createdAt,
        Instant updatedAt,
        String updater,
        Long methodId
) implements Transaction {
}
