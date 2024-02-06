package com.sokima.saas.mic.hex.escs.infra.config;

import com.sokima.lib.grpc.envelope.relay.api.v1.ReactorUnaryEnvelopeRelayServiceGrpc;
import com.sokima.lib.grpcclient.api.EnvelopeProperties;
import com.sokima.lib.grpcclient.api.EnvelopeStub;
import com.sokima.lib.grpcclient.channel.ChannelFactory;
import com.sokima.lib.grpcclient.holder.GrpcClientHolder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcBridgeConfiguration {

    @EnvelopeStub
    ReactorUnaryEnvelopeRelayServiceGrpc.ReactorUnaryEnvelopeRelayServiceStub checkoutInitiationStub(
            final ChannelFactory channelFactory,
            final GrpcClientHolder checkoutInitiationClientHolder
    ) {
        return ReactorUnaryEnvelopeRelayServiceGrpc.newReactorStub(channelFactory.newNettyChannel(checkoutInitiationClientHolder));
    }

    @EnvelopeProperties(property = "grpc.client.checkout-initiation.holder")
    GrpcClientHolder checkoutInitiationClientHolder() {
        return new GrpcClientHolder();
    }
}
