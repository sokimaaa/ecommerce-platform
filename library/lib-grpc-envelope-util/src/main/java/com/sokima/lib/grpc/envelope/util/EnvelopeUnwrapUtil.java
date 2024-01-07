package com.sokima.lib.grpc.envelope.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import com.sokima.lib.grpc.envelope.relay.api.v1.Header;

import java.util.Map;
import java.util.stream.Collectors;

public final class EnvelopeUnwrapUtil {

    private EnvelopeUnwrapUtil() {
        throw new UnsupportedOperationException("Instantiation of util class is forbidden.");
    }

    public static <T extends Message> T unwrapBody(final Envelope envelope, final Class<T> unpackType) {
        try {
            return envelope.getBody().getPayload().unpack(unpackType);
        } catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Map<String, String> unwrapHeaders(final Envelope envelope) {
        return envelope.getHeaderList()
                .stream()
                .collect(
                        Collectors.toMap(
                                Header::getKey,
                                Header::getValue
                        )
                );
    }
}
