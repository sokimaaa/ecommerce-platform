package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;

import java.time.Instant;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
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

        final Long cartId = 123L;
        final List<Long> allProductsInCart = List.of(10L, 10L, 1L, 3L);
        final CleanCartPayload cleanCartPaylod = new CleanCartPayload(cartId, allProductsInCart);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final var input = MergingTransformer.merge(cleanCartPaylod, cart);
        final var actual = tuple2CleanedCart.transform(input);
        final var expected = new CartRecord(cartId, cartId, Instant.now(), List.of());

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertNotNull(actual.cartId(), "CartId shouldn't be null after transforming.");
        Assertions.assertNotNull(actual.updater(), "Updater shouldn't be null after transforming.");
        Assertions.assertNotNull(actual.userId(), "UserId shouldn't be null after transforming.");
        Assertions.assertNotNull(actual.updatedAt(), "UdpatedAt shouldn't be null after transforming.");
        Assertions.assertNotNull(actual.productIds(), "List of product Ids shouldn't be null after transforming.");

        EqualsBuilder.reflectionEquals(expected, actual);
    }

    @Test
    void transform_mappingNonNullDelete1RepeatedProduct_True() {

        final Long cartId = 123L;
        final List<Long> allProductsInCart = List.of(10L, 10L, 1L, 3L);
        final List<Long> deletedProducts = List.of(10L);
        final CleanCartPayload cleanCartPaylod = new CleanCartPayload(cartId, deletedProducts);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final var input = MergingTransformer.merge(cleanCartPaylod, cart);
        final var actual = tuple2CleanedCart.transform(input);
        final var expected = new CartRecord(cartId, cartId, Instant.now(), List.of(10L, 1L, 3L));

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");

        int transformedListSize = actual.productIds().size();
        Assertions.assertEquals(3, transformedListSize, "Size of transformed list didn't match");

        EqualsBuilder.reflectionEquals(expected, actual);
    }
}
