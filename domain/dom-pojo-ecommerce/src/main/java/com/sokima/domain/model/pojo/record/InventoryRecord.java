package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Inventory;

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
