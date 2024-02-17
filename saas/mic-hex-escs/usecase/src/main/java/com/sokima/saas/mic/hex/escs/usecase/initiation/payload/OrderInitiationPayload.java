package com.sokima.saas.mic.hex.escs.usecase.initiation.payload;

public record OrderInitiationPayload(
        Long cartId,
        String shippingAddress,
        String paymentMethod
) {
}
