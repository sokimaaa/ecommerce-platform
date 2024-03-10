package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.initiation.mapper.Tuple2EnrichedPayloadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.function.Tuple2;

public final class Tuple2EnrichedPayloadTransformer implements Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> {

    private static final Logger log = LoggerFactory.getLogger(Tuple2EnrichedPayloadTransformer.class);

    @Override
    public EnrichedOrderInitiationPayload transform(final Tuple2<OrderInitiationPayload, Cart> input) {
        log.debug("Enriching the order initiation payload: {}", input);
        return Tuple2EnrichedPayloadMapper.INSTANCE.map(input);
    }
}
