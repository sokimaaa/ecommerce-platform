package com.sokima.domain.model.pojo;

import java.io.Serializable;

public interface Warehouse extends Updatable, Serializable {
    /**
     * the warehouse unique identifier.
     *
     * @return the warehouse id
     */
    Long warehouseId();

    /**
     * the address location of warehouse.
     * for delivery measurements.
     *
     * @return the address
     */
    String address();
}
