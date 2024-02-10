package com.sokima.lib.ecommerce.java.domain.model;

import java.time.Instant;

public interface Updatable {

    /**
     * the timestamp where item was last updated.
     *
     * @return the timestamp
     */
    Instant updatedAt();

    /**
     * the name of updater.
     *
     * @return the updater name
     */
    String updater();
}
