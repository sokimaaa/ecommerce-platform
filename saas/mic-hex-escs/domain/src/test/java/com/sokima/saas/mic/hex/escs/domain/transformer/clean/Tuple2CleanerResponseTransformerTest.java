package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

class Tuple2CleanerResponseTransformerTest {

    Tuple2CleanerResponseTransformer tuple2CleanerResponse;

    @BeforeEach
    void setUp() {
        this.tuple2CleanerResponse = new Tuple2CleanerResponseTransformer();
    }

    @Test
    void transform_fullClean_validCleanerResponse() {
        final var cartBeforeClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L));
        final var updatedCart = new CartRecord(1L, 2L, Instant.MIN, Collections.emptyList());
        final var cleanCartPayload = new CleanCartPayload(1L, List.of(1L, 2L, 3L));

        final var actual = tuple2CleanerResponse.transform(MergingTransformer.merge(cleanCartPayload, updatedCart));

        Assertions.assertNotNull(actual, "Response can't be null after transformation.");
        Assertions.assertEquals(1L, actual.getCartId(), "CartId didn't match after transformation.");
        Assertions.assertFalse(actual.getCleanedProductIds().isEmpty(), "Cleaned Product Ids is empty after transformation with full clean.");
        Assertions.assertIterableEquals(List.of(1L, 2L, 3L), actual.getCleanedProductIds(), "Cleaned Product Ids didn't match after transformation.");
        Assertions.assertTrue(actual.getOk(), "Cart was updated, but response return false.");
    }

    @Test
    void transform_partialClean_validCleanerResponse() {
        final var cartBeforeClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L, 3L));
        final var updatedCart = new CartRecord(1L, 2L, Instant.MIN, List.of(3L));
        final var cleanCartPayload = new CleanCartPayload(1L, List.of(1L, 2L, 3L));

        final var actual = tuple2CleanerResponse.transform(MergingTransformer.merge(cleanCartPayload, updatedCart));

        Assertions.assertNotNull(actual, "Response can't be null after transformation.");
        Assertions.assertEquals(1L, actual.getCartId(), "CartId didn't match after transformation.");
        Assertions.assertFalse(actual.getCleanedProductIds().isEmpty(), "Cleaned Product Ids is empty after transformation with full clean.");
        Assertions.assertIterableEquals(List.of(1L, 2L, 3L), actual.getCleanedProductIds(), "Cleaned Product Ids didn't match after transformation.");
        Assertions.assertTrue(actual.getOk(), "Cart was updated, but response return false.");
    }

    @Test
    void transform_failedClean_invalidCleanerResponse() {
        final var cartBeforeClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L));
        final var updatedCart = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L));
        final var cleanCartPayload = new CleanCartPayload(1L, List.of(1L, 2L, 3L));

        final var actual = tuple2CleanerResponse.transform(MergingTransformer.merge(cleanCartPayload, updatedCart));

        Assertions.assertNotNull(actual, "Response can't be null after transformation.");
        Assertions.assertEquals(1L, actual.getCartId(), "CartId didn't match after transformation.");
        Assertions.assertTrue(actual.getCleanedProductIds().isEmpty(), "Cleaned Product Ids should be empty after failed update of cart.");
        Assertions.assertFalse(actual.getOk(), "Cart wasn't updated, but response return true.");
    }
}
