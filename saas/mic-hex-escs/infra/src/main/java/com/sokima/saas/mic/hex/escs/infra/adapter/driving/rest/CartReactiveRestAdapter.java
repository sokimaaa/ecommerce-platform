package com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest;

import com.sokima.lib.hex.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.api.CartCheckoutReactiveApi;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.explore.v1.api.CartExplorationReactiveApi;
import com.sokima.saas.mic.hex.escs.spec.rest.explore.v1.response.CartItemsExplorationResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.api.CartCleanerReactiveApi;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.api.CartManagementReactiveApi;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.request.CartPuttingRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartPuttingResponse;
import com.sokima.saas.mic.hex.escs.usecase.CartUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

@DrivingAdapter
public class CartReactiveRestAdapter implements CartExplorationReactiveApi, CartManagementReactiveApi, CartCheckoutReactiveApi, CartCleanerReactiveApi {
    private final CartUseCase cartUseCase;

    public CartReactiveRestAdapter(final CartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }

    @Override
    public Mono<ResponseEntity<CartCheckoutResponse>> checkout(
            final Long cartId,
            final CartCheckoutRequest cartCheckoutRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new CartCheckoutResponse(
                -1L,
                -1L,
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<CartItemsExplorationResponse>> show(
            final Long cartId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new CartItemsExplorationResponse(
                -1L,
                Boolean.FALSE,
                Collections.emptyList()
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<CartCleanerResponse>> clean(
            final Long cartId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new CartCleanerResponse(
                -1L,
                Collections.emptyList(),
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<CartCleanerResponse>> clean(
            final Long cartId,
            final Long itemId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new CartCleanerResponse(
                -1L,
                Collections.emptyList(),
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<CartPuttingResponse>> put(
            final Long cartId,
            final CartPuttingRequest cartPuttingRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new CartPuttingResponse(
                -1L,
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
