package com.sokima.saas.mic.hex.eims.domain.model.record;


import com.sokima.saas.mic.hex.eims.domain.model.Warehouse;

import java.time.Instant;

public record WarehouseRecord(
        Long warehouseId,
        String address,
        Instant updatedAt,
        String updater
) implements Warehouse {
}
