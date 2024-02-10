package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Item;

public final class ItemProto implements com.sokima.lib.ecommerce.java.domain.model.Item {
    private final Item delegate;

    public ItemProto(final Item delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long itemId() {
        return delegate.getItemId();
    }

    @Override
    public Long orderId() {
        return delegate.getOrderId();
    }

    @Override
    public Long productId() {
        return delegate.getProductId();
    }

    @Override
    public Integer quantity() {
        return delegate.getQuantity();
    }

    @Override
    public Float price() {
        return delegate.getPrice();
    }
}
