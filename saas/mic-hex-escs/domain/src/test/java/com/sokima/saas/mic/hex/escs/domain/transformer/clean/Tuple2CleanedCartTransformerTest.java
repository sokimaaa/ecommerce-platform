package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

class Tuple2CleanedCartTransformerTest {

    Tuple2CleanedCartTransformer tuple2CleanedCart;

    @BeforeEach
    void setUp() {
        this.tuple2CleanedCart = new Tuple2CleanedCartTransformer();
    }

    @Test
    void transform_fullClean_cleaned() {
        final var payloadToClean = new CleanCartPayload(1L, List.of(1L, 2L, 3L));
        final var cartToBeingClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L));

        final Cart cleanedCart = tuple2CleanedCart.transform(MergingTransformer.merge(payloadToClean, cartToBeingClean));

        Assertions.assertNotNull(cleanedCart, "Cleaned Cart shouldn't be null after transforming.");

        Assertions.assertEquals(1L, cleanedCart.cartId(), "CartId didn't match after transforming.");
        Assertions.assertEquals(2L, cleanedCart.userId(), "UserId didn't match after transforming.");
//      TODO: test time being updated  Assertions.assertEquals(Instant.MIN, cleanedCart.updatedAt(), "");
        Assertions.assertNotNull(cleanedCart.updater(), "Missing updater after clean.");

        Assertions.assertTrue(cleanedCart.productIds().isEmpty(), "Cart wasn't cleaned.");
    }

    @Test
    void transform_fullCleanRepeating_cleaned() {
        final var payloadToClean = new CleanCartPayload(1L, List.of(1L, 2L, 3L, 3L));
        final var cartToBeingClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L, 3L));

        final Cart cleanedCart = tuple2CleanedCart.transform(MergingTransformer.merge(payloadToClean, cartToBeingClean));

        Assertions.assertNotNull(cleanedCart, "Cleaned Cart shouldn't be null after transforming.");

        Assertions.assertEquals(1L, cleanedCart.cartId(), "CartId didn't match after transforming.");
        Assertions.assertEquals(2L, cleanedCart.userId(), "UserId didn't match after transforming.");
        //      TODO: test time being updated  Assertions.assertEquals(Instant.MIN, cleanedCart.updatedAt(), "");
        Assertions.assertNotNull(cleanedCart.updater(), "Missing updater after clean.");

        Assertions.assertTrue(cleanedCart.productIds().isEmpty(), "Cart wasn't cleaned.");
    }

    @Test
    void transform_partialClean_cleaned() {
        final var payloadToClean = new CleanCartPayload(1L, List.of(1L, 2L));
        final var cartToBeingClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L, 3L));

        final Cart cleanedCart = tuple2CleanedCart.transform(MergingTransformer.merge(payloadToClean, cartToBeingClean));

        Assertions.assertNotNull(cleanedCart, "Cleaned Cart shouldn't be null after transforming.");

        Assertions.assertEquals(1L, cleanedCart.cartId(), "CartId didn't match after transforming.");
        Assertions.assertEquals(2L, cleanedCart.userId(), "UserId didn't match after transforming.");
        //      TODO: test time being updated  Assertions.assertEquals(Instant.MIN, cleanedCart.updatedAt(), "");
        Assertions.assertNotNull(cleanedCart.updater(), "Missing updater after clean.");

        Assertions.assertFalse(cleanedCart.productIds().isEmpty(), "Cart was fully cleaned, but expected partial clean.");
        Assertions.assertEquals(2, cleanedCart.productIds().size(), "Was cleaned extra elements from cart.");
        Assertions.assertIterableEquals(List.of(3L, 3L), cleanedCart.productIds(), "Cart elements after clean didn't match.");
    }

    @Test
    void transform_partialCleanRepeating_cleaned() {
        final var payloadToClean = new CleanCartPayload(1L, List.of(3L));
        final var cartToBeingClean = new CartRecord(1L, 2L, Instant.MIN, List.of(1L, 2L, 3L, 3L));

        final Cart cleanedCart = tuple2CleanedCart.transform(MergingTransformer.merge(payloadToClean, cartToBeingClean));

        Assertions.assertNotNull(cleanedCart, "Cleaned Cart shouldn't be null after transforming.");

        Assertions.assertEquals(1L, cleanedCart.cartId(), "CartId didn't match after transforming.");
        Assertions.assertEquals(2L, cleanedCart.userId(), "UserId didn't match after transforming.");
        //      TODO: test time being updated  Assertions.assertEquals(Instant.MIN, cleanedCart.updatedAt(), "");
        Assertions.assertNotNull(cleanedCart.updater(), "Missing updater after clean.");

        Assertions.assertFalse(cleanedCart.productIds().isEmpty(), "Cart was fully cleaned, but expected partial clean.");
        Assertions.assertEquals(3, cleanedCart.productIds().size(), "Was cleaned extra elements from cart.");
        Assertions.assertIterableEquals(List.of(1L, 2L, 3L), cleanedCart.productIds(), "Cart elements after clean didn't match.");
    }
}
