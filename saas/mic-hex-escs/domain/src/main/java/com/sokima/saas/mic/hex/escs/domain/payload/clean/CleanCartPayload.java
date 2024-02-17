package com.sokima.saas.mic.hex.escs.domain.payload.clean;

import java.util.List;

public record CleanCartPayload(
        Long cartId,

        /**
         *  may be repeated that means need to clean one product twice or more.
         */
        List<Long> productIdsToClean
) {
}
