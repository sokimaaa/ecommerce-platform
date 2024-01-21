package com.sokima.lib.request.dispatcher;

import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class EnvelopeDispatcher implements RequestDispatcher<Envelope, Envelope> {

    private final List<RequestProcessor<Envelope, Envelope>> processors;
    private final FallbackRequestProcessor<Envelope, Envelope> fallbackProcessor;

    public EnvelopeDispatcher(
            final List<RequestProcessor<Envelope, Envelope>> processors,
            FallbackRequestProcessor<Envelope, Envelope> fallbackProcessor
    ) {
        this.processors = processors;
        this.fallbackProcessor = fallbackProcessor;
    }

    @Override
    public Flux<Envelope> dispatch(Flux<Envelope> input) {
        return Flux.fromIterable(processors)
                .filter(p -> p.isSupport(input))
                .defaultIfEmpty(fallbackProcessor)
                .flatMap(p -> p.process(input));
    }
}
