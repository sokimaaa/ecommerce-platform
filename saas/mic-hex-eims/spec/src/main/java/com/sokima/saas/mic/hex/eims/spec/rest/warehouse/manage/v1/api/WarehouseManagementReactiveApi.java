package com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.api;

import com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.request.WarehouseCreationRequest;
import com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.response.WarehouseCreationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "manageWarehouse", description = "the reactive manageWarehouse API")
public interface WarehouseManagementReactiveApi {

    /**
     * POST /warehouses : Create the warehouse
     *
     * @param warehouseCreationRequest - (required)
     * @param serverWebExchange        - (optional)
     * @return OK (status code 201)
     */
    @Operation(
            operationId = "createWarehouse",
            summary = "Creation of a new warehouse",
            tags = {"createWarehouse"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = WarehouseCreationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid address of warehouse"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            }

    )
    @PostMapping(
            value = "/warehouses",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<WarehouseCreationResponse>> create(
            @Parameter(name = "warehouseCreationRequest", required = true) @Valid @RequestBody WarehouseCreationRequest warehouseCreationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
