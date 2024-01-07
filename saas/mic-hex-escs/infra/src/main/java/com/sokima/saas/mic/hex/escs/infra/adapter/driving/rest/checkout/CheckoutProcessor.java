package com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout;

import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import reactor.core.publisher.Mono;

public interface CheckoutProcessor {
    Mono<CartCheckoutResponse> process(final Long cartId, final CartCheckoutRequest cartCheckoutRequest);
}
