package com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc;

import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import com.sokima.lib.grpc.envelope.relay.api.v1.ReactorUnaryEnvelopeRelayServiceGrpc;
import com.sokima.lib.grpc.envelope.util.EnvelopeUnwrapUtil;
import com.sokima.lib.grpcserver.api.EnvelopeImplementation;
import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@EnvelopeImplementation
public class OrderManagementUnaryGrpcAdapter extends ReactorUnaryEnvelopeRelayServiceGrpc.UnaryEnvelopeRelayServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(OrderManagementUnaryGrpcAdapter.class);

//    private final EnvelopeRequestResolver resolver;
//
//    public OrderManagementUnaryGrpcAdapter(final EnvelopeRequestResolver resolver) {
//        this.resolver = resolver;
//    }

    @Override
    public Mono<Envelope> relay(Mono<Envelope> request) {
        throw new UnsupportedOperationException();
//        return reques
//        return request.doOnNext(envelope -> log.info("Inbound Envelope[body={}] of Type[type={}]", envelope, envelope.getBody().getType()))
//                .map(envelope -> EnvelopeUnwrapUtil.unwrapBody(
//                                envelope, InitiateOrderCreation.class
//                        )
//                )
//                .doOnNext(initiation -> log.debug("Initiation request after unpacking: {}", initiation))
////                .flatMap(creationUseCase::createOrder)
//                .doOnNext(completion -> log.debug("Outbound CompletionOrderCreation[body={}]", completion))
////                .map(completion -> EnvelopeWrapUtil.wrapEnvelope(
//////                                completion, CompletionOrderCreation.class
////                        )
////                )
//                .doOnNext(envelope -> log.info("Outbound Envelope[body={}] of Type[type={}]", envelope, envelope.getBody().getType()))
//                .doOnError(ex -> log.warn("Error occurred while order creation: ", ex))
//                .doOnSuccess(x -> log.info("Envelope[body={}] request was processed successfully.", x))
//                .log();
    }
}
