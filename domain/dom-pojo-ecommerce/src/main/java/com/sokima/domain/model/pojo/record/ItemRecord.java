package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Item;

public record ItemRecord(
        Long itemId,
        Long orderId,
        Long productId,
        Integer quantity,
        Float price
) implements Item {
}
