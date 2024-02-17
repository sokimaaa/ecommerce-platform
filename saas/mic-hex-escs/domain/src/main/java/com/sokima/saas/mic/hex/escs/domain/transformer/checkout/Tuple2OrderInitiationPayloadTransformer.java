package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper.Tuple2OrderInitiationPayloadMapper;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.function.Tuple2;

public final class Tuple2OrderInitiationPayloadTransformer implements Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> {
    private static final Logger log = LoggerFactory.getLogger(Tuple2OrderInitiationPayloadTransformer.class);

    @Override
    public OrderInitiationPayload transform(final Tuple2<Long, CartCheckoutRequest> input) {
        log.debug("Transforming tuple with cartId and CartCheckoutRequest: {}", input);
        return Tuple2OrderInitiationPayloadMapper.INSTANCE.map(input);
    }
}
