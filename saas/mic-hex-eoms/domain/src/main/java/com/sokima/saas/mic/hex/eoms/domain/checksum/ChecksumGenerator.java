package com.sokima.saas.mic.hex.eoms.domain.checksum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

abstract class ChecksumGenerator {

    private static final Logger log = LoggerFactory.getLogger(ChecksumGenerator.class);

    protected ChecksumGenerator() {
        throw new UnsupportedOperationException("Instantiation of util class is forbidden.");
    }

    protected static String generateOrderChecksum(
            final long userId,
            final List<Long> productIds
    ) {
        log.debug("Generates order checksum based on UserId[{}], ProductIds[{}].", userId, productIds);
        throw new UnsupportedOperationException();
    }
}
