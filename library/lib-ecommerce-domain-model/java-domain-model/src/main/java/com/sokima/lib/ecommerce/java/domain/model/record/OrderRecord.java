package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Order;

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
