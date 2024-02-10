package com.sokima.saas.mic.hex.escs.domain.service;

import com.sokima.lib.ecommerce.proto.domain.model.CompletionOrderCreation;
import com.sokima.lib.ecommerce.proto.domain.model.InitiateOrderCreation;
import com.sokima.lib.hex.architecture.annotation.OutPort;
import reactor.core.publisher.Mono;

@OutPort
public interface CheckoutInitiationService {
    Mono<CompletionOrderCreation> initiateOrderCreation(final InitiateOrderCreation outbound);
}
