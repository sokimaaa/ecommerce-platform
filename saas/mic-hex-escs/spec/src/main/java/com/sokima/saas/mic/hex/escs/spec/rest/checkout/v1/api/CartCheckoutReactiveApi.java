package com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.api;

import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "checkoutCart", description = "the reactive checkoutCart API")
public interface CartCheckoutReactiveApi {

    /**
     * POST /carts/{cartId} : Checkout Cart
     *
     * @param cartId              - (required)
     * @param cartCheckoutRequest - (required)
     * @param serverWebExchange   - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "checkoutCart",
            summary = "Checkout the cart",
            tags = {"checkoutCart"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CartCheckoutResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Incorrect checkout request"
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
                            description = "Cart not found"
                    )
            }
    )
    @PostMapping(
            value = "/carts/{cartId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<CartCheckoutResponse>> checkout(
            @Parameter(name = "cartId", required = true) @PathVariable("cartId") final Long cartId,
            @Parameter(name = "cartCheckoutRequest", required = true) @Valid @RequestBody CartCheckoutRequest cartCheckoutRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
