package com.sokima.saas.mic.hex.epgs.domain.model;

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
