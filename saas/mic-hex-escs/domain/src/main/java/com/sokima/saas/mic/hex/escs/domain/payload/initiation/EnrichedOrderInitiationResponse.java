package com.sokima.saas.mic.hex.escs.domain.payload.initiation;

import com.sokima.lib.ecommerce.java.domain.model.Item;

import java.util.Set;

public record EnrichedOrderInitiationResponse(
        Long cartId,
        Long transactionId,
        Long orderId,
        Set<Item> reservedItems,
        Boolean ok
) {
}
