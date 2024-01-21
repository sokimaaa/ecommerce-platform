package com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc;

import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import com.sokima.lib.grpc.envelope.relay.api.v1.ReactorUnaryEnvelopeRelayServiceGrpc;
import com.sokima.lib.grpc.envelope.util.EnvelopeUnwrapUtil;
import com.sokima.lib.grpc.envelope.util.EnvelopeWrapUtil;
import com.sokima.lib.grpcserver.api.EnvelopeImplementation;
import com.sokima.lib.proto.spec.eoms.CompletionOrderCreation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import com.sokima.saas.mic.hex.eoms.usecase.creation.CreationUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

//@EnvelopeImplementation
public class OrderCreationGrpcAdapter extends ReactorUnaryEnvelopeRelayServiceGrpc.UnaryEnvelopeRelayServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(OrderCreationGrpcAdapter.class);

    private final CreationUseCase creationUseCase;

    public OrderCreationGrpcAdapter(final CreationUseCase creationUseCase) {
        this.creationUseCase = creationUseCase;
    }

    @Override
    public Mono<Envelope> relay(final Mono<Envelope> request) {
        return request.doOnNext(envelope -> log.debug("Inbound Envelope[body={}] to initiate order creation.", envelope))
                .map(envelope -> EnvelopeUnwrapUtil.unwrapBody(
                                envelope, InitiateOrderCreation.class
                        )
                )
                .doOnNext(initiation -> log.debug("Initiation request after unpacking: {}", initiation))
                .flatMap(creationUseCase::createOrder)
                .doOnNext(completion -> log.debug("Outbound CompletionOrderCreation[body={}]", completion))
                .map(completion -> EnvelopeWrapUtil.wrapEnvelope(
                            completion, CompletionOrderCreation.class
                        )
                )
                .doOnError(ex -> log.warn("Error occurred while order creation: ", ex))
                .doOnSuccess(x -> log.info("InitiateOrderCreation[body={}] request was processed successfully.", x))
                .log();
    }
}
