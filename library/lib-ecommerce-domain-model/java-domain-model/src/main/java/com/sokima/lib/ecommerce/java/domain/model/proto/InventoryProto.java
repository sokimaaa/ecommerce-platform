package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Inventory;

import java.time.Instant;

public final class InventoryProto implements com.sokima.lib.ecommerce.java.domain.model.Inventory {
    private final Inventory delegate;

    public InventoryProto(final Inventory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long inventoryId() {
        return delegate.getInventoryId();
    }

    @Override
    public Long warehouseId() {
        return delegate.getWarehouseId();
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
    public Instant updatedAt() {
        return Instant.ofEpochSecond(delegate.getUpdatedAt().getSeconds());
    }

    @Override
    public String updater() {
        return delegate.getUpdater();
    }
}
