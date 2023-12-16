package com.sokima.saas.mic.hex.eoms.domain.model.record;

import com.sokima.saas.mic.hex.eoms.domain.model.Order;

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
