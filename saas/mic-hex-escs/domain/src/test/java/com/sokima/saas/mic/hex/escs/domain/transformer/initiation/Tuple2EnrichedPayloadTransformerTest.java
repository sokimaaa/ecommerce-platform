package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

class Tuple2EnrichedPayloadTransformerTest {

    Tuple2EnrichedPayloadTransformer tuple2EnrichedPayload;

    @BeforeEach
    void setUp() {
        this.tuple2EnrichedPayload = new Tuple2EnrichedPayloadTransformer();
    }

    @Test
    void transform_validPayloadAndEnrichment_enriched() {
        final var orderInitPayload = new OrderInitiationPayload(1L,
                "2911 Jesse Walk, Howellfurt, RI 69089",
                "PAYPAL");
        final var enrichmentCart = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L, 3L));

        final var actual = tuple2EnrichedPayload.transform(MergingTransformer.merge(orderInitPayload, enrichmentCart));

        Assertions.assertNotNull(actual, "EnrichedPayload can't be null after transformation.");
        Assertions.assertEquals(1L, actual.cartId(), "Cart Id didn't match after transformation.");
        Assertions.assertEquals(2L, actual.userId(), "Cart Id didn't match after transformation.");
        Assertions.assertEquals("2911 Jesse Walk, Howellfurt, RI 69089", actual.shippingAddress(), "Address didn't match after transformation.");
        Assertions.assertEquals("PAYPAL", actual.paymentMethod(), "Payment method didn't match after transformation.");
        Assertions.assertFalse(actual.productIds().isEmpty(), "Product Ids is empty after transformation.");
        Assertions.assertIterableEquals(List.of(1L, 2L, 3L, 3L), actual.productIds(), "Product Ids didn't match after transformation.");
    }
}