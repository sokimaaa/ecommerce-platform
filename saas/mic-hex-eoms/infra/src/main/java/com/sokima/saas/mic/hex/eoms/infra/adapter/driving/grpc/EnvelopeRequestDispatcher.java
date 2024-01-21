package com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc;

import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import org.apache.logging.log4j.message.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EnvelopeRequestDispatcher {

    private final Flux<RequestProcessor<? extends Message, ? extends Message>> processors;

    public EnvelopeRequestDispatcher(final Flux<RequestProcessor<? extends Message, ? extends Message>> processors) {
        this.processors = processors;
    }

    public Mono<Envelope> resolve(final Envelope envelope) {
        throw new UnsupportedOperationException();
//        return processors
//                .filter(p -> p.isProcessable(envelope))
//                .flatMap(p -> p.process(EnvelopeUnwrapUtil.unwrapBody(envelope, p.iType())))
//                .doOnNext(log inbound)
//                .map(x -> processors.stream()
//                        .filter(p -> p.isProcessable(envelope))
//                        .findFirst()
//                        .orElse()
//                )

//                .doOnNext(log outbound)
    }
}
