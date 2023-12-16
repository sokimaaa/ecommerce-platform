package com.sokima.saas.mic.hex.eims.infra.adapter.driving.rest;

import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.explore.v1.api.InventoryExplorationReactiveApi;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.explore.v1.response.InventoryExplorationResponse;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.api.InventoryManagementReactiveApi;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.request.InventoryAllocationRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.request.InventorySupplementRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.response.InventoryAllocationResponse;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.response.InventorySupplementResponse;
import com.sokima.saas.mic.hex.eims.usecase.InventoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
public class InventoryReactiveRestAdapter implements InventoryExplorationReactiveApi, InventoryManagementReactiveApi {
    private final InventoryUseCase inventoryUseCase;

    public InventoryReactiveRestAdapter(final InventoryUseCase inventoryUseCase) {
        this.inventoryUseCase = inventoryUseCase;
    }

    @Override
    public Mono<ResponseEntity<InventoryExplorationResponse>> explore(
            final Long warehouseId,
            final Long inventoryId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new InventoryExplorationResponse(
                -1L,
                -1L,
                Boolean.FALSE,
                null
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<InventorySupplementResponse>> supply(
            final Long warehouseId,
            final Long inventoryId,
            final InventorySupplementRequest inventorySupplementRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new InventorySupplementResponse(
                -1L,
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<InventoryAllocationResponse>> allocate(
            final Long warehouseId,
            final InventoryAllocationRequest inventoryAllocationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new InventoryAllocationResponse(
                -1L,
                -1L,
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
