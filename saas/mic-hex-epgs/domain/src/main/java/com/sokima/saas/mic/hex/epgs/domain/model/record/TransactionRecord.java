package com.sokima.saas.mic.hex.epgs.domain.model.record;

import com.sokima.saas.mic.hex.epgs.domain.model.Transaction;

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
