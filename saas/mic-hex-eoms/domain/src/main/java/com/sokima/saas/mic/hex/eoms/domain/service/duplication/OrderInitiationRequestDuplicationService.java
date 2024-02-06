package com.sokima.saas.mic.hex.eoms.domain.service.duplication;

import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import com.sokima.saas.mic.hex.eoms.domain.checksum.InitiateOrderCreationChecksumGenerator;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.order.FindOrderPersistentOutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public final class OrderInitiationRequestDuplicationService implements RequestDuplicationService<InitiateOrderCreation> {

    private static final Logger log = LoggerFactory.getLogger(OrderInitiationRequestDuplicationService.class);

    private final FindOrderPersistentOutPort findOrderPersistentPort;

    public OrderInitiationRequestDuplicationService(final FindOrderPersistentOutPort findOrderPersistentPort) {
        this.findOrderPersistentPort = findOrderPersistentPort;
    }

    @Override
    public Mono<Boolean> isDuplicated(final InitiateOrderCreation request) {
        final String checksum = InitiateOrderCreationChecksumGenerator.generateInitiateOrderCreationChecksum(request);
        return findOrderPersistentPort.findSingleOrder(checksum)
                .map(order -> Boolean.FALSE)
                .defaultIfEmpty(Boolean.TRUE)
                .doOnNext(x -> log.info("InitiateOrderCreation request is duplicated : {}", x));
    }
}
