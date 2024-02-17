package com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout;

import com.sokima.lib.hex.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.api.CartCheckoutReactiveApi;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.usecase.checkout.CartCheckoutFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
@RestController
@RequestMapping("api/v1")
public class CheckoutReactiveAdapter implements CartCheckoutReactiveApi {

    private static final Logger log = LoggerFactory.getLogger(CheckoutReactiveAdapter.class);

    private final CartCheckoutFlow cartCheckoutFlow;

    public CheckoutReactiveAdapter(final CartCheckoutFlow cartCheckoutFlow) {
        this.cartCheckoutFlow = cartCheckoutFlow;
    }

    @Override
    public Mono<ResponseEntity<CartCheckoutResponse>> checkout(
            final Long cartId,
            final CartCheckoutRequest cartCheckoutRequest,
            final ServerWebExchange serverWebExchange
    ) {
        log.debug("Inbound CartCheckoutRequest[cartId={}, request={}]", cartId, cartCheckoutRequest);
        return cartCheckoutFlow.doFlow(cartId, cartCheckoutRequest)
                .single()
                .doOnNext(x -> log.debug("Outbound CartCheckoutResponse[body={}]", x))
                .map(ResponseEntity::ok)
                .doOnError(ex -> log.warn("Error occurred while cart checkout: ", ex))
                .doOnSuccess(x -> log.info("CartCheckoutRequest[cartId={},request={}] was processed successfully.", cartId, cartCheckoutRequest))
                .log();
    }
}
