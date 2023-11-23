package com.sokima.specification.rest.transactioncomplete.api;

import com.sokima.specification.rest.transactioncomplete.response.TransactionCompletionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "completeTransaction", description = "the reactive completeTransaction API")
public interface TransactionCompletionReactiveApi {

    /**
     * PATCH /transactions/{transactionId} : Complete Transaction
     *
     * @param transactionId     - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "completeTransaction",
            summary = "Complete the transaction",
            tags = {"completeTransaction"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TransactionCompletionResponse.class)
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
                            description = "Transaction not found"
                    )
            }
    )
    @PatchMapping(
            value = "/transactions/{transactionId}",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<?>> complete(
            @Parameter(name = "transactionId", required = true) @PathVariable("transactionId") final Long transactionId,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
