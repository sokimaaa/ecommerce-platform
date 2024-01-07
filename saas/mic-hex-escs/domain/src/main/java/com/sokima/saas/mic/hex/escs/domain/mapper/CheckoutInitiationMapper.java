package com.sokima.saas.mic.hex.escs.domain.mapper;

import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;

import java.util.Set;

public interface CheckoutInitiationMapper {
    static InitiateOrderCreation composeInitiateOrderCreation(
            final Long userId,
            final Set<Long> productIds,
            final String shippingAddress,
            final String paymentMethod
    ) {
        return InitiateOrderCreation.newBuilder()
                .setUserId(userId)
                .addAllProductIds(productIds)
                .setShippingAddress(shippingAddress)
                .setPaymentMethod(paymentMethod)
                .build();
    }
}
