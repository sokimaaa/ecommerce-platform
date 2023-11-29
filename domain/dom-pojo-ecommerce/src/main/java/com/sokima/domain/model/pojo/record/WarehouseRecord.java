package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Warehouse;

import java.time.Instant;

public record WarehouseRecord(
        Long warehouseId,
        String address,
        Instant updatedAt,
        String updater
) implements Warehouse {
}
