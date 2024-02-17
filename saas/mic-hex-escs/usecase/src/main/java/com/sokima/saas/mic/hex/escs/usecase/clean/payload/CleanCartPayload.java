package com.sokima.saas.mic.hex.escs.usecase.clean.payload;

import java.util.List;

public record CleanCartPayload(
        Long cartId,

        /**
         *  may be repeated that means need to clean one product twice or more.
         */
        List<Long> productIdsToClean
) {
}
