package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tuple2OrderInitiationPayloadTransformerTest {
    Tuple2OrderInitiationPayloadTransformer tuple2OrderInitiationPayload;

    @BeforeEach
    void setup() {
        this.tuple2OrderInitiationPayload = new Tuple2OrderInitiationPayloadTransformer();
    }

    @Test
    void transform_mappingNonNull_True() {
        final var cartId = 10L;
        final var cartCheckoutRequest = new CartCheckoutRequest(
                "2911 Jesse Walk, Howellfurt, RI 69089",
                "PAYPAL"
        );

        final var input = MergingTransformer.merge(cartId, cartCheckoutRequest);

        final var actual = tuple2OrderInitiationPayload.transform(input);

        Assertions.assertNotNull(actual, "Payload shouldn't be null after transforming.");

        Assertions.assertNotNull(actual.cartId(), "CartId of payload shouldn't be bull after transforming.");
        Assertions.assertEquals(10L, actual.cartId(), "CartId of payload didn't match after transforming.");

        Assertions.assertNotNull(actual.shippingAddress(), "Shipping address of payload shouldn't be bull after transforming.");
        Assertions.assertEquals("2911 Jesse Walk, Howellfurt, RI 69089", actual.shippingAddress(), "Shipping address of payload didn't match after transforming.");

        Assertions.assertNotNull(actual.shippingAddress(), "Payment method of payload shouldn't be bull after transforming.");
        Assertions.assertEquals("PAYPAL", actual.paymentMethod(), "Payment method of payload didn't match after transforming.");
    }
}