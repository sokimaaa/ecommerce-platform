package com.sokima.lib.building.block.transformer.request;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;

public interface EnvelopeRequestTransformer<O> extends Transformer<Envelope, O> {
}
