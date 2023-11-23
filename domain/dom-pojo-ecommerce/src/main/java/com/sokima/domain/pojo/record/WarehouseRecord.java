package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Warehouse;

import java.time.Instant;

public record WarehouseRecord(
        Long warehouseId,
        String address,
        Instant updatedAt,
        String updater
) implements Warehouse {
}
