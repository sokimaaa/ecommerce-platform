package com.sokima.lib.grpc.envelope.util;

import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.sokima.lib.grpc.envelope.relay.api.v1.Body;
import com.sokima.lib.grpc.envelope.relay.api.v1.Envelope;
import com.sokima.lib.grpc.envelope.relay.api.v1.Header;

import java.util.Collections;
import java.util.Map;

// https://www.enterpriseintegrationpatterns.com/patterns/messaging/EnvelopeWrapper.html
public final class EnvelopeWrapUtil {

    private EnvelopeWrapUtil() {
        throw new UnsupportedOperationException("Instantiation of util class is forbidden.");
    }

    public static <T extends Message> Envelope wrapEnvelope(final T payload, final Class<T> payloadType) {
        return wrapEnvelope(Collections.emptyMap(), payload, payloadType);
    }

    public static <T extends Message> Envelope wrapEnvelope(final Map<String, String> headers, final T payload, final Class<T> payloadType) {
        final var envelope = Envelope.newBuilder();
        headers.forEach((k, v) -> {
            final Header header = wrapHeader(k, v);
            envelope.addHeader(header);
        });

        return envelope.setBody(
                        wrapBody(payload, payloadType)
                )
                .build();
    }

    private static <T extends Message> Body wrapBody(final T payload, final Class<T> payloadType) {
        return Body.newBuilder()
                .setType(payloadType.getName())
                .setPayload(Any.pack(payload))
                .build();
    }

    private static Header wrapHeader(final String key, final String value) {
        return Header.newBuilder()
                .setKey(key)
                .setValue(value)
                .build();
    }
}
