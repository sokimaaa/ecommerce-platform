package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.ecommerce.proto.domain.model.Item;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Tuple2EnrichedOrderInitiationResponseTransformerTest {

    Tuple2EnrichedOrderInitiationResponseTransformer tuple2EnrichedOrderInitiationResponse;

    @BeforeEach
    void setup() {
        this.tuple2EnrichedOrderInitiationResponse = new Tuple2EnrichedOrderInitiationResponseTransformer();
    }

    @Test
    void transform_mappingNonNull_True() {
        final var orderInitPayload = new OrderInitiationPayload(
                1L,
                "2911 Jesse Walk, Howellfurt, RI 69089",
                "PAYPAL"
        );
        final var orderInitResp = OrderInitiationResponse.newBuilder()
                .setOrderId(1L)
                .setTransactionId(1L)
                .addReservedItems(item())
                .addReservedItems(item())
                .addReservedItems(item())
                .setOk(Boolean.TRUE)
                .build();
        final var input = MergingTransformer.merge(orderInitPayload, orderInitResp);

        final var actual = tuple2EnrichedOrderInitiationResponse.transform(input);

        Assertions.assertNotNull(actual, "Response shouldn't be null after transforming.");

        Assertions.assertEquals(1L, actual.cartId(), "CardI shouldn't be null after transforming.");
        Assertions.assertEquals(1L, actual.transactionId(), "Transaction id after transforming didn't match.");
        Assertions.assertEquals(1L, actual.orderId(), "Order id after transforming didn't match.");

        final var items = actual.reservedItems();
        Assertions.assertFalse(items.isEmpty(), "Reserved items is empty after transformation.");
        Assertions.assertEquals(3, items.size(), "Reserved items size didn't match.");

        Assertions.assertTrue(actual.ok(), "Boolean status after transforming corrupted.");
    }

    private Item item() {
        return Item.newBuilder().build();
    }
}