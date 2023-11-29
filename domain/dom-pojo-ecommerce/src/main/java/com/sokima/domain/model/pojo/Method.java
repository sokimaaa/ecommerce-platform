package com.sokima.domain.model.pojo;

import java.io.Serializable;

public interface Method extends Serializable {
    /**
     * the unique method identifier.
     *
     * @return the method id
     */
    Long methodId();

    /**
     * the payment method type.
     *
     * @return the type
     */
    String type();
}
