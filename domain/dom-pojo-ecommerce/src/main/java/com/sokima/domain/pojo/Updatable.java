package com.sokima.domain.pojo;

import java.time.Instant;

interface Updatable {

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
