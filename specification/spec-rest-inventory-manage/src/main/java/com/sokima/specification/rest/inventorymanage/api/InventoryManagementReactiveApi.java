package com.sokima.specification.rest.inventorymanage.api;

import com.sokima.specification.rest.inventorymanage.request.InventoryAllocationRequest;
import com.sokima.specification.rest.inventorymanage.request.InventorySupplementRequest;
import com.sokima.specification.rest.inventorymanage.response.InventoryAllocationResponse;
import com.sokima.specification.rest.inventorymanage.response.InventorySupplementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "manageInventory", description = "the reactive manageInventory API")
public interface InventoryManagementReactiveApi {

    /**
     * PATCH /warehouses/{warehouseId}/inventories/{inventoryId} : Supply Inventory
     *
     * @param warehouseId                - (required)
     * @param inventoryId                - (required)
     * @param inventorySupplementRequest - (required)
     * @param serverWebExchange          - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "supplyInventory",
            summary = "Supply the inventory with new products",
            tags = {"supplyInventory"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = InventorySupplementResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid supplement request"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Warehouse or inventory not found"
                    )
            }
    )
    @PatchMapping(
            value = "/warehouses/{warehouseId}/inventories/{inventoryId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<InventorySupplementResponse>> supply(
            @Parameter(name = "warehouseId", required = true) @PathVariable("warehouseId") final Long warehouseId,
            @Parameter(name = "inventoryId", required = true) @PathVariable("inventoryId") final Long inventoryId,
            @Parameter(name = "inventorySupplementRequest", required = true) @Valid @RequestBody InventorySupplementRequest inventorySupplementRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * POST /warehouses/{warehouseId}/inventories : Allocate Inventory
     *
     * @param warehouseId                - (required)
     * @param inventoryAllocationRequest - (required)
     * @param serverWebExchange          - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "allocateInventory",
            summary = "Allocate a new space in warehouse for the inventory",
            tags = {"allocateInventory"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = InventoryAllocationResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid allocation request"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Warehouse not found"
                    )
            }
    )
    @PostMapping(
            value = "/warehouses/{warehouseId}/inventories",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<InventoryAllocationResponse>> allocate(
            @Parameter(name = "warehouseId", required = true) @PathVariable("warehouseId") final Long warehouseId,
            @Parameter(name = "inventoryAllocationRequest", required = true) @Valid @RequestBody InventoryAllocationRequest inventoryAllocationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
