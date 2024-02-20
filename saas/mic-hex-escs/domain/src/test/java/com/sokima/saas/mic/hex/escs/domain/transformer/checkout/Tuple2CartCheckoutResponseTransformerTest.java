package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.util.function.Tuple2;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Tuple2CartCheckoutResponseTransformerTest {

    Tuple2CartCheckoutResponseTransformer tuple2CartCheckoutResponse;

    @BeforeEach
    void setup() {
        this.tuple2CartCheckoutResponse = new Tuple2CartCheckoutResponseTransformer();
    }

    @Test
    void transform_mappingValid_True() {
        final var enrichedOrderInitResp = new EnrichedOrderInitiationResponse(
                1L, 1L, 1L, Collections.emptySet(), Boolean.TRUE
        );
        final var cartCleanerResp = new CartCleanerResponse(
                1L, Collections.emptyList(), Boolean.TRUE
        );
        final var input = MergingTransformer.merge(enrichedOrderInitResp, cartCleanerResp);

        final var actual = tuple2CartCheckoutResponse.transform(input);

        Assertions.assertNotNull(actual, "Response shouldn't be null after transforming.");

        Assertions.assertEquals(1L, actual.getCartId(), "Cart id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getTransactionId(), "Transaction id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getOrderId(), "Order id after transforming didn't match.");
        Assertions.assertTrue(actual.getOk(), "Boolean status after transforming corrupted.");
    }

    @Test
    void transform_mappingInvalidCartId_False() {
        final var enrichedOrderInitResp = new EnrichedOrderInitiationResponse(
                2L, 1L, 1L, Collections.emptySet(), Boolean.TRUE
        );
        final var cartCleanerResp = new CartCleanerResponse(
                1L, Collections.emptyList(), Boolean.TRUE
        );
        final var input = MergingTransformer.merge(enrichedOrderInitResp, cartCleanerResp);

        final var actual = tuple2CartCheckoutResponse.transform(input);

        Assertions.assertNotNull(actual, "Response shouldn't be null after transforming.");

        Assertions.assertEquals(-1L, actual.getCartId(), "Cart id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getTransactionId(), "Transaction id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getOrderId(), "Order id after transforming didn't match.");
        Assertions.assertTrue(actual.getOk(), "Boolean status after transforming corrupted.");
    }

    @Test
    void transform_mappingOk_False() {
        final var enrichedOrderInitResp = new EnrichedOrderInitiationResponse(
                1L, 1L, 1L, Collections.emptySet(), Boolean.TRUE
        );
        final var cartCleanerResp = new CartCleanerResponse(
                1L, Collections.emptyList(), Boolean.FALSE
        );
        final var input = MergingTransformer.merge(enrichedOrderInitResp, cartCleanerResp);

        final var actual = tuple2CartCheckoutResponse.transform(input);

        Assertions.assertNotNull(actual, "Response shouldn't be null after transforming.");

        Assertions.assertEquals(1L, actual.getCartId(), "Cart id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getTransactionId(), "Transaction id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.getOrderId(), "Order id after transforming didn't match.");
        Assertions.assertFalse(actual.getOk(), "Boolean status after transforming corrupted.");
    }
}