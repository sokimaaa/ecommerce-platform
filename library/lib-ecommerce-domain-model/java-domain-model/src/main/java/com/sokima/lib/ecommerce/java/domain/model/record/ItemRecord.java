package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Item;

public record ItemRecord(
        Long itemId,
        Long orderId,
        Long productId,
        Integer quantity,
        Float price
) implements Item {
}
