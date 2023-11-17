package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Inventory;

import java.time.Instant;

public record InventoryRecord(
        Long inventoryId,
        Long warehouseId,
        Long productId,
        Instant updatedAt,
        String updater,
        Integer quantity
) implements Inventory {
}
