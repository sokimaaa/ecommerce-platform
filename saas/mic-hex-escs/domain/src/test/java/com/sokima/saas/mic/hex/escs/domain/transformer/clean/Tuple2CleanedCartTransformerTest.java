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

class Tuple2CleanedCartTransformerTest {

    Tuple2CleanedCartTransformer tuple2CleanedCart;

    @BeforeEach
    void setUp() {
        this.tuple2CleanedCart = new Tuple2CleanedCartTransformer();
    }

    @Test
    void transform_mappingNonNullDeleteAllProducts_True() {
        final var cartId = 123L;
        final var allProductsInCart = List.of(10L, 10L, 1L, 3L);
        final CleanCartPayload cleanCartPaylod = new CleanCartPayload(cartId, allProductsInCart);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final var input = MergingTransformer.merge(cleanCartPaylod, cart);
        final var actual = tuple2CleanedCart.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");

        Assertions.assertNotNull(actual.cartId(), "CartId shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.cartId(), "CartId after transforming didn't match.");
        Assertions.assertNotNull(actual.userId(), "UserId shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.userId(), "UserId after transforming didn't match.");

        Assertions.assertNotNull(actual.productIds(), "List of product Ids shouldn't be null after transforming.");
        Assertions.assertTrue(actual.productIds().isEmpty(), "List of products didn't empty after transformation.");
    }

    @Test
    void transform_mappingNonNullDelete1RepeatedProduct_True() {
        final var cartId = 123L;
        final var allProductsInCart = List.of(10L, 10L, 1L, 3L);
        final var deletedProducts = List.of(10L);
        final CleanCartPayload cleanCartPaylod = new CleanCartPayload(cartId, deletedProducts);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final var input = MergingTransformer.merge(cleanCartPaylod, cart);
        final var actual = tuple2CleanedCart.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertEquals(3, actual.productIds().size(), "Size of transformed list didn't match");
    }
}
