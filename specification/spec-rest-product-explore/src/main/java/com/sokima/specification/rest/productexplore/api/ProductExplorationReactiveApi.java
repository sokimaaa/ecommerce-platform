package com.sokima.specification.rest.productexplore.api;

import com.sokima.specification.rest.productexplore.response.MultipleProductExplorationResponse;
import com.sokima.specification.rest.productexplore.response.SingleProductExplorationResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "exploreProduct", description = "the reactive exploreProduct API")
public interface ProductExplorationReactiveApi {

    /**
     * GET /products : Multiple Products Explore
     *
     * @param filter            - (optional)
     * @param sort              - (optional)
     * @param page              - (optional)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "exploreMultipleProducts",
            summary = "Exploring the multiple products",
            tags = {"exploreProducts", "exploreMultipleProducts"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MultipleProductExplorationResponse.class)
                            )
                    )
            }
    )
    @GetMapping(
            value = "/products",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<MultipleProductExplorationResponse>> explore(
            @Parameter(name = "filter") @RequestParam(name = "filter", required = false) final String filter,
            @Parameter(name = "sort") @RequestParam(name = "sort", required = false) final String sort,
            @Parameter(name = "page") @RequestParam(name = "page", defaultValue = "0", required = false) final Integer page,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * GET /products/{productId} : Single Product Explore
     *
     * @param productId         - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "exploreSingleProduct",
            summary = "Exploring the single product",
            tags = {"exploreProduct", "exploreSingleProduct"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SingleProductExplorationResponse.class)
                            )
                    )
            }
    )
    @GetMapping(
            value = "/products/{productId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<SingleProductExplorationResponse>> explore(
            @Parameter(name = "productId", required = true) @PathVariable("productId") final Long productId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
