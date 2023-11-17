package com.sokima.domain.pojo;

import java.io.Serializable;

public interface Item extends Serializable {
    /**
     * the unique identifier of item that relates to specific order.
     *
     * @return the item id
     */
    Long itemId();

    /**
     * the order that owns an item.
     *
     * @return the order id
     */
    Long orderId();

    /**
     * the product that was added to order.
     *
     * @return the product id
     */
    Long productId();

    /**
     * number of products that was ordered.
     *
     * @return the quantity
     */
    Integer quantity();

    /**
     * the price of current item that calculates by `quantity * productPrice`.
     *
     * @return the price
     */
    Float price();
}
