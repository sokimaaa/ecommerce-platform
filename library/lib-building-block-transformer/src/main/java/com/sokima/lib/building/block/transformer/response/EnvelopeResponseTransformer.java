package com.sokima.lib.building.block.transformer.response;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;

public interface EnvelopeResponseTransformer<I> extends Transformer<I, Envelope> {
}
