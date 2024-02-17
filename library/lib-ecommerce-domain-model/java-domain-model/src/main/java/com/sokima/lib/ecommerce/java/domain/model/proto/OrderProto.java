package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Order;

import java.time.Instant;
import java.util.Set;

public final class OrderProto implements com.sokima.lib.ecommerce.java.domain.model.Order {
    private final Order delegate;

    public OrderProto(final Order delegate) {
        this.delegate = delegate;
    }

    @Override
    public Instant createdAt() {
        return Instant.ofEpochSecond(delegate.getCreatedAt().getSeconds());
    }

    @Override
    public Long orderId() {
        return delegate.getOrderId();
    }

    @Override
    public String status() {
        return delegate.getStatus();
    }

    @Override
    public Float total() {
        return Float.parseFloat(delegate.getTotal()); // todo: fix proto string->float field
    }

    @Override
    public String shippingAddress() {
        return delegate.getShippingAddress();
    }

    @Override
    public String postalTrackingId() {
        return delegate.getPostalTrackingId();
    }

    @Override
    public String paymentMethod() {
        return delegate.getPaymentMethod();
    }

    @Override
    public Set<Long> itemIds() {
        return Set.copyOf(delegate.getItemIdsList());
    }

    @Override
    public Long userId() {
        return delegate.getUserId();
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
