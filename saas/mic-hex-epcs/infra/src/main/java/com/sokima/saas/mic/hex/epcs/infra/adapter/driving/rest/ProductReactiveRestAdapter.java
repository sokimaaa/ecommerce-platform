package com.sokima.saas.mic.hex.epcs.infra.adapter.driving.rest;

import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.epcs.spec.rest.explore.v1.api.ProductExplorationReactiveApi;
import com.sokima.saas.mic.hex.epcs.spec.rest.explore.v1.response.MultipleProductExplorationResponse;
import com.sokima.saas.mic.hex.epcs.spec.rest.explore.v1.response.SingleProductExplorationResponse;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.api.ProductModificationReactiveApi;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.request.DescriptionModificationRequest;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.request.NameModificationRequest;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.request.PriceModificationRequest;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.response.DescriptionModificationResponse;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.response.NameModificationResponse;
import com.sokima.saas.mic.hex.epcs.spec.rest.modify.v1.response.PriceModificationResponse;
import com.sokima.saas.mic.hex.epcs.usecase.ProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

@DrivingAdapter
public class ProductReactiveRestAdapter implements ProductExplorationReactiveApi, ProductModificationReactiveApi {
    private final ProductUseCase productUseCase;

    public ProductReactiveRestAdapter(final ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    public Mono<ResponseEntity<MultipleProductExplorationResponse>> explore(
            final String filter,
            final String sort,
            final Integer page,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new MultipleProductExplorationResponse(
                Boolean.FALSE,
                Collections.emptyList()
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<SingleProductExplorationResponse>> explore(
            final Long productId,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new SingleProductExplorationResponse(
                -1L,
                Boolean.FALSE,
                null
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<NameModificationResponse>> modify(
            final Long productId,
            final NameModificationRequest nameModificationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new NameModificationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<DescriptionModificationResponse>> modify(
            final Long productId,
            final DescriptionModificationRequest descriptionModificationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new DescriptionModificationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<PriceModificationResponse>> modify(
            final Long productId,
            final PriceModificationRequest priceModificationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new PriceModificationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
