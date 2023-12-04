package com.sokima.infrastructure.microservice.eoms.adapter.driving.rest;

import com.sokima.application.microservice.eoms.usecase.ItemUseCase;
import com.sokima.application.microservice.eoms.usecase.OrderUseCase;
import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.specification.rest.order.explore.v1.api.OrderExplorationReactiveApi;
import com.sokima.specification.rest.order.explore.v1.response.OrderExplorationResponse;
import com.sokima.specification.rest.order.explore.v1.response.OrderHistoryExplorationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

@DrivingAdapter
public class OrderReactiveRestAdapter implements OrderExplorationReactiveApi {
    private final OrderUseCase orderUseCase;

    private final ItemUseCase itemUseCase;

    public OrderReactiveRestAdapter(final OrderUseCase orderUseCase, final ItemUseCase itemUseCase) {
        this.orderUseCase = orderUseCase;
        this.itemUseCase = itemUseCase;
    }

    @Override
    public Mono<ResponseEntity<OrderExplorationResponse>> show(
            final Long orderId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new OrderExplorationResponse(
                -1L,
                Boolean.FALSE,
                null
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<OrderHistoryExplorationResponse>> show(
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new OrderHistoryExplorationResponse(
                Boolean.FALSE,
                Collections.emptyList()
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
