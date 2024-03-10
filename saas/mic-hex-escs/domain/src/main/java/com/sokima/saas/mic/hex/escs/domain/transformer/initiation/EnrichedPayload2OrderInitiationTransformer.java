package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.initiation.mapper.EnrichedPayload2OrderInitiationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EnrichedPayload2OrderInitiationTransformer implements Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> {

    private static final Logger log = LoggerFactory.getLogger(EnrichedPayload2OrderInitiationTransformer.class);

    @Override
    public OrderInitiationRequest transform(final EnrichedOrderInitiationPayload input) {
        log.debug("Transforming EnrichedOrderInitiationPayload to order initiation request: {}", input);
        return EnrichedPayload2OrderInitiationMapper.INSTANCE.map(input);
    }
}
