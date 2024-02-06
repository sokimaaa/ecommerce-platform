package com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout.mapper;

import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;

public interface CheckoutResponseMapper {
    static CartCheckoutResponse composeCheckoutResponse(
            final CompletionOrderCreation completionOrderCreation
    ) {
        return new CartCheckoutResponse(
                completionOrderCreation.getCartId(),
                completionOrderCreation.getTransactionId(),
                completionOrderCreation.getOrderId(),
                completionOrderCreation.getOk()
        );
    }

    static CartCheckoutResponse composeCheckoutResponse(
            final CartCheckoutResponse cartCheckoutResponse, final Boolean bool
    ) {
        return new CartCheckoutResponse(
                cartCheckoutResponse.getCartId(),
                cartCheckoutResponse.getTransactionId(),
                cartCheckoutResponse.getOrderId(),
                cartCheckoutResponse.getOk() && bool
        );
    }
}
