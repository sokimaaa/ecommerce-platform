package com.sokima.lib.grpcclient.config;

import com.sokima.lib.grpcclient.channel.ChannelFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class GrpcClientAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ChannelFactory channelBuilderFactory() {
        return new ChannelFactory();
    }
}
