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

        final Long cartId = 123L;
        final List<Long> allProductsInCart = List.of(10L, 10L, 1L, 3L);
        final List<Long> deletedProducts = List.of(10L);
        final Cart cart = new CartRecord(cartId, cartId, Instant.now(), allProductsInCart);
        final CleanCartPayload cartPayload = new CleanCartPayload(cartId, deletedProducts);
        final var input = MergingTransformer.merge(cartPayload, cart);
        final var actual = tuple2CleanerResponse.transform(input);

        Assertions.assertNotNull(actual, "Object shouldn't be null after transforming.");
        Assertions.assertEquals(123L, actual.getCartId());
        Assertions.assertEquals(1L, actual.getCleanedProductIds().size());
        Assertions.assertTrue(actual.getOk(), "Boolean status after transforming corrupted.");
    }
}
