package com.sokima.saas.mic.hex.eims.infra.adapter.driving.rest;

import com.sokima.lib.hex.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.explore.v1.api.InventoryExplorationReactiveApi;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.explore.v1.response.InventoryExplorationResponse;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.api.InventoryManagementReactiveApi;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.request.InventoryAllocationRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.request.InventorySupplementRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.response.InventoryAllocationResponse;
import com.sokima.saas.mic.hex.eims.spec.rest.inventory.manage.v1.response.InventorySupplementResponse;
import com.sokima.saas.mic.hex.eims.usecase.InventoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
public class InventoryReactiveRestAdapter implements InventoryExplorationReactiveApi, InventoryManagementReactiveApi {
    private static final Logger log = LoggerFactory.getLogger(InventoryReactiveRestAdapter.class);

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
        log.debug("Inbound InventoryExplorationRequest[warehouseId={},inventoryId={}]", warehouseId, inventoryId);
        final var body = new InventoryExplorationResponse(
                -1L,
                -1L,
                Boolean.FALSE,
                null
        );
        return Mono.just(body)
                .doOnNext(x -> log.debug("Outbound InventoryExplorationResponse[body={}]", x))
                .map(ResponseEntity::ok)
                .doOnError(ex -> log.warn("Error occurred while inventory exploration: ", ex))
                .doOnSuccess(x -> log.info("InventoryExplorationRequest[warehouseId={},inventoryId={}] was processed successfully.", warehouseId, inventoryId));
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
