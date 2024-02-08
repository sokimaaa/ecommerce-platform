package com.sokima.lib.core.transformer.request;

import com.sokima.lib.core.transformer.Transformer;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;

public interface EnvelopeRequestTransformer<O> extends Transformer<Envelope, O> {
}
