package com.sokima.domain.model.pojo;

import java.io.Serializable;

public interface Inventory extends Updatable, Serializable {

    /**
     * the inventory unique identifier.
     *
     * @return the inventory id
     */
    Long inventoryId();

    /**
     * the warehouse that accumulates this inventory.
     *
     * @return the warehouse id
     */
    Long warehouseId();

    /**
     * the product that stores.
     *
     * @return the product id
     */
    Long productId();

    /**
     * the quantity of the product that available in the inventory.
     *
     * @return the quantity
     */
    Integer quantity();
}
