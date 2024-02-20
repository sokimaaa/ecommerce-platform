package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.ecommerce.java.domain.model.Item;
import com.sokima.lib.ecommerce.java.domain.model.immutable.ImmutableItemImpl;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class EnrichedOrderInitiationResponse2CartCleanPayloadTransformerTest {

    EnrichedOrderInitiationResponse2CartCleanPayloadTransformer enrichedOrderInitiationResponse2CartCleanPayload;

    @BeforeEach
    void setup() {
        this.enrichedOrderInitiationResponse2CartCleanPayload = new EnrichedOrderInitiationResponse2CartCleanPayloadTransformer();
    }

    @Test
    void transform_mappingRepeating_True() {
        final var input = new EnrichedOrderInitiationResponse(
                1L,
                -1L,
                -1L,
                Set.of(
                        item(3, 10L),
                        item(2, 3L)
                ),
                Boolean.FALSE
        );

        final var actual = enrichedOrderInitiationResponse2CartCleanPayload.transform(input);

        Assertions.assertNotNull(actual, "Payload shouldn't be null after transforming.");

        Assertions.assertEquals(1L, actual.cartId());

        final var productIdsToClean = actual.productIdsToClean();
        Assertions.assertFalse(productIdsToClean.isEmpty(), "Product ids list is empty after transformation.");
        Assertions.assertEquals(5, productIdsToClean.size(), "Product ids list size didn't match.");
        Assertions.assertTrue(productIdsToClean.containsAll(List.of(3L, 10L)), "Product ids list has corrupted values.");
    }

    @Test
    void transform_mappingNonRepeating_True() {
        final var input = new EnrichedOrderInitiationResponse(
                3L,
                -1L,
                -1L,
                Set.of(
                        item(1, 2L),
                        item(1, 5L)
                ),
                Boolean.FALSE
        );

        final var actual = enrichedOrderInitiationResponse2CartCleanPayload.transform(input);

        Assertions.assertNotNull(actual, "Payload shouldn't be null after transforming.");

        Assertions.assertEquals(3L, actual.cartId());

        final var productIdsToClean = actual.productIdsToClean();
        Assertions.assertFalse(productIdsToClean.isEmpty(), "Product ids list is empty after transformation.");
        Assertions.assertEquals(2, productIdsToClean.size(), "Product ids list size didn't match.");
        Assertions.assertTrue(productIdsToClean.containsAll(List.of(2L, 5L)), "Product ids list has corrupted values.");
    }

    private Item item(final int quantity, final long productId) {
        return ImmutableItemImpl.builder()
                .orderId(-1L)
                .price(-1f)
                .itemId(-1L)
                .quantity(quantity)
                .productId(productId)
                .build();
    }
}