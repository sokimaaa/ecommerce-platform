package com.sokima.saas.mic.hex.escs.domain.payload.initiation;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.immutable.ImmutableCartImpl;

import java.util.List;

public record EnrichedOrderInitiationPayload(
        Long cartId,
        Long userId,
        List<Long> productIds,
        String shippingAddress,
        String paymentMethod
) {
    public Cart cart() {
        return ImmutableCartImpl.builder()
                .cartId(cartId)
                .userId(userId)
                .productIds(productIds)
                .build();
    }
}
