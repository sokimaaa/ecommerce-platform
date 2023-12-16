package com.sokima.saas.mic.hex.eoms.domain.model.record;

import com.sokima.saas.mic.hex.eoms.domain.model.Item;

public record ItemRecord(
        Long itemId,
        Long orderId,
        Long productId,
        Integer quantity,
        Float price
) implements Item {
}
