package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tuple2CleanerResponseTransformerTest {

    Tuple2CleanerResponseTransformer tuple2CleanerResponse;

    @BeforeEach
    void setUp() {
        this.tuple2CleanerResponse = new Tuple2CleanerResponseTransformer();
    }

    @Test
    void transform_mappingValid_True() {
        final var cartId = 123L;
        final var allProductsInCart = List.of(1L, 2L, 3L, 3L, 3L);
        final var deletedProducts = List.of(1L, 2L, 3L, 3L);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final CleanCartPayload cartPayload = new CleanCartPayload(cartId, deletedProducts);
        final var input = MergingTransformer.merge(cartPayload, cart);
        final var actual = tuple2CleanerResponse.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.getCartId(), "CartId after transforming didn't match.");
        Assertions.assertEquals(4, actual.getCleanedProductIds().size(), "Product ids list size didn't match.");
        // TODO: Assertions.assertTrue(actual.getOk(), "Boolean status after transforming corrupted.");
    }

    @Test
    void transform_mappingWrong_False() {
        final var cartId = 123L;
        final var allProductsInCart = List.of(1L, 2L, 3L, 3L, 3L);
        final var deletedProducts = List.of(1L, 2L, 3L, 3L);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final CleanCartPayload cartPayload = new CleanCartPayload(cartId, deletedProducts);
        final var input = MergingTransformer.merge(cartPayload, cart);
        final var actual = tuple2CleanerResponse.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.getCartId(), "CartId after transforming didn't match.");
        Assertions.assertEquals(4, actual.getCleanedProductIds().size(), "Product ids list size didn't match.");
        Assertions.assertFalse(actual.getOk(), "Boolean status after transforming corrupted.");

        Assertions.assertNotEquals(List.of(3L, 3L), actual.getCleanedProductIds(), "Transformation went wrong, lists shouldn't match.");
    }

    @Test
    void transform_mappingWrong2_False() {
        final var cartId = 123L;
        final var allProductsInCart = List.of(1L, 2L, 3L, 3L, 3L);
        final var deletedProducts = List.of(1L, 2L, 3L, 3L);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final CleanCartPayload cartPayload = new CleanCartPayload(cartId, deletedProducts);
        final var input = MergingTransformer.merge(cartPayload, cart);
        final var actual = tuple2CleanerResponse.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.getCartId(), "CartId after transforming didn't match.");
        Assertions.assertEquals(4, actual.getCleanedProductIds().size(), "Product ids list size didn't match.");
        Assertions.assertFalse(actual.getOk(), "Boolean status after transforming corrupted.");

        Assertions.assertNotEquals(List.of(1L, 2L, 3L, 3L, 3L), actual.getCleanedProductIds(), "Transformation went wrong, lists shouldn't match.");
    }
}
