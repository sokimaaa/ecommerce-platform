package com.sokima.specification.rest.product.modify.v1.api;

import com.sokima.specification.rest.product.modify.v1.request.DescriptionModificationRequest;
import com.sokima.specification.rest.product.modify.v1.request.NameModificationRequest;
import com.sokima.specification.rest.product.modify.v1.request.PriceModificationRequest;
import com.sokima.specification.rest.product.modify.v1.response.DescriptionModificationResponse;
import com.sokima.specification.rest.product.modify.v1.response.NameModificationResponse;
import com.sokima.specification.rest.product.modify.v1.response.PriceModificationResponse;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "modifyProduct", description = "the reactive modifyProduct API")
public interface ProductModificationReactiveApi {

    /**
     * PATCH /products/{productId}/name : Name Modification
     *
     * @param productId               - (required)
     * @param nameModificationRequest - (required)
     * @param serverWebExchange       - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "modifyProductName",
            summary = "Modification of product name",
            tags = {"modifyProductName", "modifyName"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = NameModificationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Incorrect modification request or illegal modification"
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
    @PatchMapping(
            value = "/products/{productId}/name",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<NameModificationResponse>> modify(
            @Parameter(name = "productId", required = true) @PathVariable("productId") final Long productId,
            @Parameter(name = "nameModificationRequest", required = true) @Valid @RequestBody NameModificationRequest nameModificationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * PATCH /products/{productId}/description : Description Modification
     *
     * @param productId                      - (required)
     * @param descriptionModificationRequest - (required)
     * @param serverWebExchange              - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "modifyProductDescription",
            summary = "Modification of product description",
            tags = {"modifyProductDescription", "modifyDescription"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DescriptionModificationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid modification request or illegal modification"
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
    @PatchMapping(
            value = "/products/{productId}/description",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<DescriptionModificationResponse>> modify(
            @Parameter(name = "productId", required = true) @PathVariable("productId") final Long productId,
            @Parameter(name = "descriptionModificationRequest", required = true) @Valid @RequestBody DescriptionModificationRequest descriptionModificationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * PATCH /products/{productId}/price : Price Modification
     *
     * @param productId                - (required)
     * @param priceModificationRequest - (required)
     * @param serverWebExchange        - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "modifyProductPrice",
            summary = "Modification of product price",
            tags = {"modifyProductPrice", "modifyPrice"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = PriceModificationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid modification request or illegal modification"
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
    @PatchMapping(
            value = "/products/{productId}/price",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<PriceModificationResponse>> modify(
            @Parameter(name = "productId", required = true) @PathVariable("productId") final Long productId,
            @Parameter(name = "priceModificationRequest", required = true) @Valid @RequestBody PriceModificationRequest priceModificationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
