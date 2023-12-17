package com.sokima.saas.mic.hex.eums.domain.model;

import java.io.Serializable;

public interface Profile extends Serializable {

    /**
     * the unique profile identifier.
     *
     * @return the profile id
     */
    Long profileId();

    /**
     * the owner of this profile.
     *
     * @return the user id
     */
    Long userId();
}
