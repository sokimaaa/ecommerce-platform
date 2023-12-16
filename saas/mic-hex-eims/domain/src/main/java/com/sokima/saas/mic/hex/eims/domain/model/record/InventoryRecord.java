package com.sokima.saas.mic.hex.eims.domain.model.record;



import com.sokima.saas.mic.hex.eims.domain.model.Inventory;

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
