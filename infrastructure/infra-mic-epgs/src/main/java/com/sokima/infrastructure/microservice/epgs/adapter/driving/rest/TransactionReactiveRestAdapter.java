package com.sokima.infrastructure.microservice.epgs.adapter.driving.rest;

import com.sokima.application.microservice.epgs.usecase.TransactionUseCase;
import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.specification.rest.transaction.complete.v1.api.TransactionCompletionReactiveApi;
import com.sokima.specification.rest.transaction.complete.v1.response.TransactionCompletionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
public class TransactionReactiveRestAdapter implements TransactionCompletionReactiveApi {
    private final TransactionUseCase transactionUseCase;

    public TransactionReactiveRestAdapter(final TransactionUseCase transactionUseCase) {
        this.transactionUseCase = transactionUseCase;
    }

    @Override
    public Mono<ResponseEntity<TransactionCompletionResponse>> complete(
            final Long transactionId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new TransactionCompletionResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
