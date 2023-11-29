package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Order;

import java.time.Instant;
import java.util.Set;

public record OrderRecord(
        Long orderId,
        String status,
        Float total,
        String shippingAddress,
        String postalTrackingId,
        String paymentMethod,
        Instant createdAt,
        Instant updatedAt,
        String updater,
        Set<Long> itemIds,
        Long userId
) implements Order {
}
