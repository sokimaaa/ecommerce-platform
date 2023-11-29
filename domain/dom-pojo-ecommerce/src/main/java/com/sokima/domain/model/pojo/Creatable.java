package com.sokima.domain.model.pojo;

import java.time.Instant;

interface Creatable {
    /**
     * the timestamp where item was created.
     *
     * @return the timestamp
     */
    Instant createdAt();
}
