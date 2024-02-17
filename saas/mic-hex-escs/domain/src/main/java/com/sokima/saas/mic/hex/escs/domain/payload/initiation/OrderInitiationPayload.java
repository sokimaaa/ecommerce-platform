package com.sokima.saas.mic.hex.escs.domain.payload.initiation;

public record OrderInitiationPayload(
        Long cartId,
        String shippingAddress,
        String paymentMethod
) {
}
