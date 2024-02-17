package com.sokima.saas.mic.hex.escs.infra.adapter.driven.grpc;

import com.sokima.lib.building.block.sender.RequestMessageSender;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.lib.grpc.envelope.relay.api.v1.ReactorUnaryEnvelopeRelayServiceGrpc;
import com.sokima.lib.grpc.envelope.util.EnvelopeUnwrapUtil;
import com.sokima.lib.grpc.envelope.util.EnvelopeWrapUtil;
import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@DrivenAdapter
public class OrderInitiationGrpcAdapter implements RequestMessageSender<OrderInitiationRequest, OrderInitiationResponse> {

    private static final Logger log = LoggerFactory.getLogger(OrderInitiationGrpcAdapter.class);

    private final ReactorUnaryEnvelopeRelayServiceGrpc.ReactorUnaryEnvelopeRelayServiceStub eomsStub;

    public OrderInitiationGrpcAdapter(
            final ReactorUnaryEnvelopeRelayServiceGrpc.ReactorUnaryEnvelopeRelayServiceStub eomsStub
    ) {
        this.eomsStub = eomsStub;
    }

    @Override
    public Flux<OrderInitiationResponse> send(final OrderInitiationRequest outbound) {
        final var envelope = EnvelopeWrapUtil.wrapEnvelope(outbound, OrderInitiationRequest.class);
        log.debug("Wrap order initiation request to envelope: {}", envelope);
        return Mono.just(envelope)
                .doOnNext(e -> log.debug(">>>>> Outbound envelope >>>>>"))
                .flatMap(eomsStub::relay)
                .doOnNext(e -> log.debug("<<<<< Inbound envelope <<<<<"))
                .doOnNext(x -> log.info("Receive envelope of order initiation response: {}", x))
                .map(x -> EnvelopeUnwrapUtil.unwrapBody(x, OrderInitiationResponse.class))
                .doOnNext(x -> log.debug("Unwrap order initiation response: {}", x))
                .flux();
    }
}
