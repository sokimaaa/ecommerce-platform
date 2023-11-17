package com.sokima.domain.pojo;

import java.io.Serializable;

public interface Transaction extends Creatable, Updatable, Serializable {
    /**
     * the unique transaction id.
     *
     * @return the transaction id
     */
    Long transactionId();

    /**
     * the payer.
     *
     * @return the user id
     */
    Long userId();

    /**
     * the order that should be paid.
     *
     * @return the order id
     */
    Long orderId();

    /**
     * the amount to be paid.
     * after all applied filters, e.g. discount, fee, and so on.
     *
     * @return the amount
     */
    Float amount();

    /**
     * the status of transaction.
     *
     * @return the status
     */
    String status();

    /**
     * expiration status of transaction.
     * after long term awaiting should be expired and declined.
     *
     * @return the boolean
     */
    Boolean expired();

    /**
     * the chosen payment method.
     *
     * @return the method id
     */
    Long methodId();
}
