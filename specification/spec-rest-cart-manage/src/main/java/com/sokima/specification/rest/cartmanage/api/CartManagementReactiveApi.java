package com.sokima.specification.rest.cartmanage.api;

import com.sokima.specification.rest.cartmanage.request.CartPuttingRequest;
import com.sokima.specification.rest.cartmanage.response.CartCleanerResponse;
import com.sokima.specification.rest.cartmanage.response.CartPuttingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "manageCart", description = "the reactive manageCart API")
public interface CartManagementReactiveApi {

    /**
     * PUT /carts/{cartId} : Put a new item to cart
     *
     * @param cartId             - (required)
     * @param cartPuttingRequest - (required)
     * @param serverWebExchange  - (optional)
     * @return OK (status code 201)
     */
    @Operation(
            operationId = "putCartItem",
            summary = "Put the item to cart",
            tags = {"putCartItem"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CartPuttingResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Incorrect put request"
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
                            description = "Cart or item not found"
                    )
            }
    )
    @PutMapping(
            value = "/carts/{cartId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<CartCleanerResponse>> put(
            @Parameter(name = "cartId", required = true) @PathVariable("cartId") final Long cartId,
            @Parameter(name = "cartPuttingRequest", required = true) @Valid @RequestBody CartPuttingRequest cartPuttingRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
