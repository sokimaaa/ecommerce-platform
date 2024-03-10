package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class EnrichedPayload2OrderInitiationTransformerTest {

    EnrichedPayload2OrderInitiationTransformer transformer;

    @BeforeEach
    void setUp() {
        this.transformer = new EnrichedPayload2OrderInitiationTransformer();
    }

    @Test
    void transform_singleItems_True() {
        final var enrichedPayload = new EnrichedOrderInitiationPayload(
                1L, 2L, List.of(1L, 2L, 3L),
                "2911 Jesse Walk, Howellfurt, RI 69089",
                "PAYPAL"
        );

        final var actual = transformer.transform(enrichedPayload);

        Assertions.assertNotNull(actual, "Order Initiation Request can't be null after transformation.");
        Assertions.assertEquals(2L, actual.getUserId(), "User Id didn't match after transformation.");
        Assertions.assertEquals("2911 Jesse Walk, Howellfurt, RI 69089", actual.getShippingAddress(), "Address didn't match after transformation.");
        Assertions.assertEquals("PAYPAL", actual.getPaymentMethod(), "Payment method didn't match after transformation.");
        Assertions.assertEquals(3, actual.getProductIdQuantityCount(), "Size didn't match after transformation.");

        final var productIdsAndQuantity = actual.getProductIdQuantityMap();
        Assertions.assertTrue(productIdsAndQuantity.containsKey(1L)
                && productIdsAndQuantity.containsKey(2L)
                && productIdsAndQuantity.containsKey(3L), "Missing product id after transforming.");

        productIdsAndQuantity.forEach(
                (productId, quantity) -> {
                    Assertions.assertEquals(1, quantity, "Expected singular quantity of products.");
                }
        );
    }

    @Test
    void transform_repeatingItems_True() {
        final var enrichedPayload = new EnrichedOrderInitiationPayload(
                1L, 2L, List.of(1L, 2L, 3L, 3L),
                "2911 Jesse Walk, Howellfurt, RI 69089",
                "PAYPAL"
        );

        final var actual = transformer.transform(enrichedPayload);

        Assertions.assertNotNull(actual, "Order Initiation Request can't be null after transformation.");
        Assertions.assertEquals(2L, actual.getUserId(), "User Id didn't match after transformation.");
        Assertions.assertEquals("2911 Jesse Walk, Howellfurt, RI 69089", actual.getShippingAddress(), "Address didn't match after transformation.");
        Assertions.assertEquals("PAYPAL", actual.getPaymentMethod(), "Payment method didn't match after transformation.");
        Assertions.assertEquals(3, actual.getProductIdQuantityCount(), "Size didn't match after transformation.");

        final var productIdsAndQuantity = actual.getProductIdQuantityMap();
        Assertions.assertTrue(
                productIdsAndQuantity.containsKey(1L)
                        && productIdsAndQuantity.get(1L).equals(1), "Missing product id or wrong quantity."
        );
        Assertions.assertTrue(
                productIdsAndQuantity.containsKey(2L)
                        && productIdsAndQuantity.get(2L).equals(1), "Missing product id or wrong quantity."
        );
        Assertions.assertTrue(
                productIdsAndQuantity.containsKey(3L)
                        && productIdsAndQuantity.get(3L).equals(2), "Missing product id or wrong quantity."
        );
    }
}