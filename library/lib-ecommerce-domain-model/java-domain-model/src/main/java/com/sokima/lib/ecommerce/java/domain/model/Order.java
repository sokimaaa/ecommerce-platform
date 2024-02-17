package com.sokima.lib.ecommerce.java.domain.model;

import java.io.Serializable;
import java.util.Set;

public interface Order extends Creatable, Updatable, Serializable {
    /**
     * unique identifier of order.
     *
     * @return the order id
     */
    Long orderId();

    /**
     * the status of an order.
     *
     * @return the status
     */
    String status();

    /**
     * total price of all items of order.
     *
     * @return the total
     */
    Float total();

    /**
     * delivering address to ship.
     *
     * @return the address
     */
    String shippingAddress();

    /**
     * the postal code id to track the delivering.
     *
     * @return the tracking id
     */
    String postalTrackingId();

    /**
     * chosen payment method.
     *
     * @return the payment method
     */
    String paymentMethod();

    /**
     * bunch of item ids that was ordered.
     *
     * @return the list of item ids
     */
    Set<Long> itemIds();

    /**
     * the user id that makes an order.
     *
     * @return the user id
     */
    Long userId();
}
