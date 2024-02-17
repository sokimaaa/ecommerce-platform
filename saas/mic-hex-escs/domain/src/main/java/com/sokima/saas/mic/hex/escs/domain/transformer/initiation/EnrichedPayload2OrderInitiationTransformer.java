package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;

public final class EnrichedPayload2OrderInitiationTransformer implements Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> {
    @Override
    public OrderInitiationRequest transform(final EnrichedOrderInitiationPayload input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
