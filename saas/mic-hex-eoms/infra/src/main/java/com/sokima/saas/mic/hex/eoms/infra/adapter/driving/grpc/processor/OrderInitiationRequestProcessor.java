package com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc.processor;

import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc.RequestProcessor;
import reactor.core.publisher.Mono;

public class OrderInitiationRequestProcessor implements RequestProcessor<InitiateOrderCreation, CompletionOrderCreation> {

    @Override
    public Mono<CompletionOrderCreation> process(final InitiateOrderCreation request) {
        return null;
    }

    @Override
    public Class<InitiateOrderCreation> type() {
        return InitiateOrderCreation.class;
    }
}
