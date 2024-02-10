package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Transaction;

import java.time.Instant;

public final class TransactionProto implements com.sokima.lib.ecommerce.java.domain.model.Transaction {
    private final Transaction delegate;

    public TransactionProto(final Transaction delegate) {
        this.delegate = delegate;
    }

    @Override
    public Instant createdAt() {
        return Instant.ofEpochSecond(delegate.getCreatedAt().getSeconds());
    }

    @Override
    public Long transactionId() {
        return delegate.getTransactionId();
    }

    @Override
    public Long userId() {
        return delegate.getUserId();
    }

    @Override
    public Long orderId() {
        return delegate.getOrderId();
    }

    @Override
    public Float amount() {
        return delegate.getAmount();
    }

    @Override
    public String status() {
        return delegate.getStatus();
    }

    @Override
    public Boolean expired() {
        return delegate.getExpired();
    }

    @Override
    public Long methodId() {
        return delegate.getMethodId();
    }

    @Override
    public Instant updatedAt() {
        return Instant.ofEpochSecond(delegate.getUpdatedAt().getSeconds());
    }

    @Override
    public String updater() {
        return delegate.getUpdater();
    }
}
