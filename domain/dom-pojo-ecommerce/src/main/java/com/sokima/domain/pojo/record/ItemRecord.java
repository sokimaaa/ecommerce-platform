package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Item;

public record ItemRecord(
        Long itemId,
        Long orderId,
        Long productId,
        Integer quantity,
        Float price
) implements Item {
}
