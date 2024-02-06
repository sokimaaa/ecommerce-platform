package com.sokima.saas.mic.hex.eoms.domain.service.product;

import com.sokima.lib.proto.spec.epcs.HoldProductRequest;
import com.sokima.lib.proto.spec.epcs.HoldProductResponse;
import reactor.core.publisher.Mono;

public interface HoldProductService {
    Mono<HoldProductResponse> putProductOnHold(final HoldProductRequest holdRequest);

    <T, S> Mono<T> approveProductHold(final S approveHoldProductRequest);
}
