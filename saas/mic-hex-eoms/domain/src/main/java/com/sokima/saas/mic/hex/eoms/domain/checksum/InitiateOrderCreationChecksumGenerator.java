package com.sokima.saas.mic.hex.eoms.domain.checksum;

import com.sokima.lib.proto.spec.eoms.InitiateOrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class InitiateOrderCreationChecksumGenerator extends ChecksumGenerator {

    private static final Logger log = LoggerFactory.getLogger(InitiateOrderCreationChecksumGenerator.class);

    private InitiateOrderCreationChecksumGenerator() {
        throw new UnsupportedOperationException("Instantiation of util class is forbidden.");
    }

    public static String generateInitiateOrderCreationChecksum(final InitiateOrderCreation initiateOrderCreation) {
        final long userId = initiateOrderCreation.getUserId();
        final List<Long> productIds = initiateOrderCreation.getProductIdsList();

        final String initiateOrderCreationChecksum = generateOrderChecksum(userId, productIds);
        log.debug("Generated checksum for InitiateOrderCreation : {}", initiateOrderCreationChecksum);
        return initiateOrderCreationChecksum;
    }
}
