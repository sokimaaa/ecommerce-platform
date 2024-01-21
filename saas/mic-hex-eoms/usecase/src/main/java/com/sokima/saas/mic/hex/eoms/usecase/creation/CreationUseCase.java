package com.sokima.saas.mic.hex.eoms.usecase.creation;

import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public final class CreationUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreationUseCase.class);

    public Mono<CompletionOrderCreation> createOrder(final InitiateOrderCreation orderCreationRequest) {
        throw new UnsupportedOperationException();
    }
}
