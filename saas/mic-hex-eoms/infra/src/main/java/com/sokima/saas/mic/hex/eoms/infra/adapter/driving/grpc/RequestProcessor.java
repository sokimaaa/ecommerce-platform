package com.sokima.saas.mic.hex.eoms.infra.adapter.driving.grpc;

import com.google.protobuf.Message;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import reactor.core.publisher.Mono;

public interface RequestProcessor<I extends Message, O extends Message> {
    Mono<O> process(final I request);

    Class<I> iType();

    Class<O> oType();

    default boolean isProcessable(final Envelope envelope) {
        return envelope.getBody().getType().equals(iType().getName());
    }
}
