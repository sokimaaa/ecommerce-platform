package com.sokima.specification.rest.cartmanage.api;

import com.sokima.specification.rest.cartmanage.response.CartCleanerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "cleanCart", description = "the reactive cleanCart API")
public interface CartCleanerReactiveApi {

    /**
     * DELETE /carts/{cartId}/items : Clean up the entire cart
     *
     * @param cartId            - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "cleanCart",
            summary = "Clean up the cart",
            tags = {"cleanCart"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CartCleanerResponse.class)
                            )
                    )
            }
    )
    @DeleteMapping(
            value = "/carts/{cartId}/items",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<CartCleanerResponse>> clean(
            @Parameter(name = "cartId", required = true) @PathVariable("cartId") final Long cartId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * DELETE /carts/{cartId}/items/{itemId} : Clean the item from the cart
     *
     * @param cartId            - (required)
     * @param itemId            - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "cleanCartItem",
            summary = "Clean the item from cart",
            tags = {"cleanCartItem"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CartCleanerResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Item does not exist already"
                    )
            }
    )
    @DeleteMapping(
            value = "/carts/{cartId}/items/{itemId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<CartCleanerResponse>> clean(
            @Parameter(name = "cartId", required = true) @PathVariable("cartId") final Long cartId,
            @Parameter(name = "itemId", required = true) @PathVariable("itemId") final Long itemId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
