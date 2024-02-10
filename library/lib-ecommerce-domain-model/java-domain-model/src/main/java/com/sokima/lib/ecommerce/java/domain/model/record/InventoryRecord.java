package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Inventory;

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
