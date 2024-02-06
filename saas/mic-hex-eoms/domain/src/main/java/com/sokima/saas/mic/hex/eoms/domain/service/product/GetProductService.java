package com.sokima.saas.mic.hex.eoms.domain.service.product;

import com.sokima.lib.proto.spec.epcs.GetProductRequest;
import com.sokima.lib.proto.spec.epcs.GetProductResponse;
import reactor.core.publisher.Flux;

public interface GetProductService {

    <T> Flux<GetProductRequest> composeRequest(T base);

    Flux<GetProductResponse> getProducts(final Flux<GetProductRequest> requests);

    default <T> Flux<GetProductResponse> getProducts(T base) {
        return getProducts(composeRequest(base));
    }
}
