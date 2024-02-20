package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper.Tuple2EnrichedOrderInitiationResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.function.Tuple2;

public final class Tuple2EnrichedOrderInitiationResponseTransformer implements Transformer<Tuple2<OrderInitiationPayload, OrderInitiationResponse>, EnrichedOrderInitiationResponse> {
    private static final Logger log = LoggerFactory.getLogger(Tuple2EnrichedOrderInitiationResponseTransformer.class);

    @Override
    public EnrichedOrderInitiationResponse transform(final Tuple2<OrderInitiationPayload, OrderInitiationResponse> input) {
        log.debug("Transforming order init payload and order init resp: {}", input);
        return Tuple2EnrichedOrderInitiationResponseMapper.INSTANCE.map(input);
    }
}
