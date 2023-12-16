package com.sokima.saas.mic.hex.escs.domain.model;

import java.time.Instant;

interface Creatable {
    /**
     * the timestamp where item was created.
     *
     * @return the timestamp
     */
    Instant createdAt();
}
