package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Warehouse;

import java.time.Instant;

public final class WarehouseProto implements com.sokima.lib.ecommerce.java.domain.model.Warehouse {
    private final Warehouse delegate;

    public WarehouseProto(final Warehouse delegate) {
        this.delegate = delegate;
    }

    @Override
    public Instant updatedAt() {
        return Instant.ofEpochSecond(delegate.getUpdatedAt().getSeconds());
    }

    @Override
    public String updater() {
        return delegate.getUpdater();
    }

    @Override
    public Long warehouseId() {
        return delegate.getWarehouseId();
    }

    @Override
    public String address() {
        return delegate.getAddress();
    }
}
