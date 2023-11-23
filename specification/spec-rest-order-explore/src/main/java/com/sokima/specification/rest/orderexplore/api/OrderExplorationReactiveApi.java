package com.sokima.specification.rest.orderexplore.api;

import com.sokima.specification.rest.orderexplore.response.OrderExplorationResponse;
import com.sokima.specification.rest.orderexplore.response.OrderHistoryExplorationResponse;
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
@Tag(name = "exploreOrder", description = "the reactive exploreOrder API")
public interface OrderExplorationReactiveApi {

    /**
     * GET /orders : Order History Explore
     *
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "exploreOrderHistory",
            summary = "Exploring order history",
            tags = {"exploreOrder", "exploreOrderHistory"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OrderHistoryExplorationResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            }
    )
    @GetMapping(
            value = "/orders",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<OrderHistoryExplorationResponse>> show(
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * GET /orders/{orderId}/items : Order Items Explore
     *
     * @param orderId           - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "exploreOrderItems",
            description = "Exploring order items",
            tags = {"exploreOrderItems"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OrderExplorationResponse.class)
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
                            description = "Order not found"
                    )
            }
    )
    @GetMapping(
            value = "/orders/{orderId}/items",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<OrderExplorationResponse>> show(
            @Parameter(name = "orderId", required = true) @PathVariable("orderId") final Long orderId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
