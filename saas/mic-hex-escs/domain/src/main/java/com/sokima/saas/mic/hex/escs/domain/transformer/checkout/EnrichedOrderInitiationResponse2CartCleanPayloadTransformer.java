package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;

public final class EnrichedOrderInitiationResponse2CartCleanPayloadTransformer implements Transformer<EnrichedOrderInitiationResponse, CleanCartPayload> {
    @Override
    public CleanCartPayload transform(final EnrichedOrderInitiationResponse input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
