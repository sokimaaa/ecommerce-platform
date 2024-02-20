package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper.Tuple2CartCheckoutResponseMapper;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.util.function.Tuple2;

public final class Tuple2CartCheckoutResponseTransformer implements Transformer<Tuple2<EnrichedOrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> {
    private static final Logger log = LoggerFactory.getLogger(Tuple2CartCheckoutResponseTransformer.class);

    @Override
    public CartCheckoutResponse transform(final Tuple2<EnrichedOrderInitiationResponse, CartCleanerResponse> input) {
        log.debug("Transforming enriched order init response and cart cleaner response: {}", input);
        return Tuple2CartCheckoutResponseMapper.INSTANCE.map(input);
    }
}
