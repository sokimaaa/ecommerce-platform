package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Cart;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public final class CartProto implements com.sokima.lib.ecommerce.java.domain.model.Cart {
    private final Cart delegate;

    public CartProto(final Cart delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long cartId() {
        return delegate.getCartId();
    }

    @Override
    public Long userId() {
        return delegate.getUserId();
    }

    @Override
    public List<Long> productIds() {
        return delegate.getProductIdsList();
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
