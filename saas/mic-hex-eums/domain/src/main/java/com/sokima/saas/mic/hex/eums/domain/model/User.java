package com.sokima.saas.mic.hex.eums.domain.model;

import java.io.Serializable;

public interface User extends Creatable, Serializable {
    /**
     * the user unique identifier.
     *
     * @return the user id
     */
    Long userId();

    /**
     * the username that shown on platform.
     * could be repeatable.
     *
     * @return the username
     */
    String username();

    /**
     * the role of user, e.g. admin, moderator, customer, seller.
     *
     * @return the role.
     */
    String role();

    /**
     * the unique email attached to user.
     *
     * @return the email
     */
    String email();

    /**
     * the in-password for user.
     * should be hashed.
     *
     * @return the password
     */
    String password();

    /**
     * the profile with additional user info.
     *
     * @return the profile id
     */
    Long profileId();
}
