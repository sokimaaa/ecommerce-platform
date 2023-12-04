package com.sokima.specification.rest.inventory.explore.v1.api;

import com.sokima.specification.rest.inventory.explore.v1.response.InventoryExplorationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "exploreInventory", description = "the reactive exploreInventory API")
public interface InventoryExplorationReactiveApi {

    /**
     * GET /warehouses/{warehouseId}/inventories/{inventoryId} : Inventory Explore
     *
     * @param warehouseId       - (required)
     * @param inventoryId       - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "exploreInventory",
            summary = "Exploring the inventory",
            tags = {"exploreInventory"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = InventoryExplorationResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Warehouse or inventory not found"
                    )
            }
    )
    @GetMapping(
            value = "/warehouses/{warehouseId}/inventories/{inventoryId}",
            produces = "application/json"
    )
    default Mono<ResponseEntity<InventoryExplorationResponse>> explore(
            @Parameter(name = "warehouseId", required = true) @PathVariable("warehouseId") final Long warehouseId,
            @Parameter(name = "inventoryId", required = true) @PathVariable("inventoryId") final Long inventoryId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
