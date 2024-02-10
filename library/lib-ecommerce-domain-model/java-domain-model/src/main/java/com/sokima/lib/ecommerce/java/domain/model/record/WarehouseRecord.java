package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Warehouse;

import java.time.Instant;

public record WarehouseRecord(
        Long warehouseId,
        String address,
        Instant updatedAt,
        String updater
) implements Warehouse {
}
