package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Transaction;

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
