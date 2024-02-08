package com.sokima.lib.core.transformer.response;

import com.sokima.lib.core.transformer.Transformer;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;

public interface EnvelopeResponseTransformer<I> extends Transformer<I, Envelope> {
}
