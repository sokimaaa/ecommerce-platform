package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Product;

import java.time.Instant;

public final class ProductProto implements com.sokima.lib.ecommerce.java.domain.model.Product {
    private final Product delegate;

    public ProductProto(final Product delegate) {
        this.delegate = delegate;
    }

    @Override
    public Instant createdAt() {
        return Instant.ofEpochSecond(delegate.getCreatedAt().getSeconds());
    }

    @Override
    public Long productId() {
        return delegate.getProductId();
    }

    @Override
    public String name() {
        return delegate.getName();
    }

    @Override
    public String description() {
        return delegate.getDescription();
    }

    @Override
    public String image() {
        return delegate.getImage();
    }

    @Override
    public Float price() {
        return delegate.getPrice();
    }

    @Override
    public String category() {
        return delegate.getCategory();
    }

    @Override
    public Long inventoryId() {
        return delegate.getInventoryId();
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
