package com.sokima.saas.mic.hex.escs.domain.service;

import com.sokima.lib.hex.architecture.annotation.OutPort;
import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import reactor.core.publisher.Mono;

@OutPort
public interface CheckoutInitiationService {
    Mono<CompletionOrderCreation> initiateOrderCreation(final InitiateOrderCreation outbound);
}
