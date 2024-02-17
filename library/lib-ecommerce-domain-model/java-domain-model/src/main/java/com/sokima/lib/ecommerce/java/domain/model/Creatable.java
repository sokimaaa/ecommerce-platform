package com.sokima.lib.ecommerce.java.domain.model;

import java.time.Instant;

public interface Creatable {
    /**
     * the timestamp where item was created.
     *
     * @return the timestamp
     */
    Instant createdAt();
}
