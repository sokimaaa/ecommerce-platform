package com.sokima.saas.mic.hex.escs.infra.adapter.driven.grpc;

import com.sokima.lib.grpc.envelope.relay.api.v1.ReactorUnaryEnvelopeRelayServiceGrpc;
import com.sokima.lib.grpc.envelope.util.EnvelopeUnwrapUtil;
import com.sokima.lib.grpc.envelope.util.EnvelopeWrapUtil;
import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import com.sokima.saas.mic.hex.escs.domain.service.CheckoutInitiationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@DrivenAdapter
public class CheckoutInitiationGrpcAdapter implements CheckoutInitiationService {

    private static final Logger log = LoggerFactory.getLogger(CheckoutInitiationGrpcAdapter.class);

    private final ReactorUnaryEnvelopeRelayServiceGrpc.ReactorUnaryEnvelopeRelayServiceStub checkoutInitiationStub;

    public CheckoutInitiationGrpcAdapter(
            final ReactorUnaryEnvelopeRelayServiceGrpc.ReactorUnaryEnvelopeRelayServiceStub checkoutInitiationStub
    ) {
        this.checkoutInitiationStub = checkoutInitiationStub;
    }

    @Override
    public Mono<CompletionOrderCreation> initiateOrderCreation(final InitiateOrderCreation outbound) {
        final var envelope = EnvelopeWrapUtil.wrapEnvelope(outbound, InitiateOrderCreation.class);
        log.debug("Wrap initiate order creation request to envelope : {}", envelope);
        return Mono.just(envelope)
                .flatMap(checkoutInitiationStub::relay)
                .doOnNext(x -> log.info("Receive envelope of complete order creation response : {}", x))
                .map(x -> EnvelopeUnwrapUtil.unwrapBody(x, CompletionOrderCreation.class))
                .doOnNext(x -> log.debug("Unwrap completion order creation response : {}", x));
    }
}
