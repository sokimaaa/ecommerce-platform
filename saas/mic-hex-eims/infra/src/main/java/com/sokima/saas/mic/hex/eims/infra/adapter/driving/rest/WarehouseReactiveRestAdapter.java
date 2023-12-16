package com.sokima.saas.mic.hex.eims.infra.adapter.driving.rest;

import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.api.WarehouseManagementReactiveApi;
import com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.request.WarehouseCreationRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.response.WarehouseCreationResponse;
import com.sokima.saas.mic.hex.eims.usecase.WarehouseUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
public class WarehouseReactiveRestAdapter implements WarehouseManagementReactiveApi {
    private final WarehouseUseCase warehouseUseCase;

    public WarehouseReactiveRestAdapter(final WarehouseUseCase warehouseUseCase) {
        this.warehouseUseCase = warehouseUseCase;
    }

    @Override
    public Mono<ResponseEntity<WarehouseCreationResponse>> create(
            final WarehouseCreationRequest warehouseCreationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new WarehouseCreationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
