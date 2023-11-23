package com.sokima.lib.grpcclient.channel;

import com.sokima.lib.grpcclient.holder.GrpcClientHolder;
import io.grpc.ManagedChannel;

public class ChannelFactory {
    public ManagedChannel newNettyChannel(final GrpcClientHolder grpcClientHolder) {
        final var channelBuilder = new ChannelBuilder(grpcClientHolder);
        return channelBuilder.buildNettyChannel();
    }
}
