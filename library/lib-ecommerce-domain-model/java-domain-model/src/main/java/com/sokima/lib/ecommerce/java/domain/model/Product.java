package com.sokima.lib.ecommerce.java.domain.model;

import java.io.Serializable;

public interface Product extends Creatable, Updatable, Serializable {

    /**
     * the unique identifier of product.
     *
     * @return the product id
     */
    Long productId();

    /**
     * the product name to be shown on the title.
     *
     * @return the product name
     */
    String name();

    /**
     * the product description to be shown on the description.
     *
     * @return the product description
     */
    String description();

    /**
     * the image location path.
     *
     * @return the image path.
     */
    String image();

    /**
     * the price of unit of product.
     *
     * @return the price
     */
    Float price();

    /**
     * the category of product, e.g. books, computers, and so on.
     *
     * @return the category
     */
    String category();

    /**
     * the inventory where product is stores.
     * One inventory per product type.
     *
     * @return the inventory id.
     */
    Long inventoryId();
}
