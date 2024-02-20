package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper.EnrichedOrderInitiationResponse2CartCleanPayloadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EnrichedOrderInitiationResponse2CartCleanPayloadTransformer implements Transformer<EnrichedOrderInitiationResponse, CleanCartPayload> {
    private static final Logger log = LoggerFactory.getLogger(EnrichedOrderInitiationResponse2CartCleanPayloadTransformer.class);

    @Override
    public CleanCartPayload transform(final EnrichedOrderInitiationResponse input) {
        log.debug("Transforming enriched order init response: {}", input);
        return EnrichedOrderInitiationResponse2CartCleanPayloadMapper.INSTANCE.map(input);
    }
}
