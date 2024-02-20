package com.sokima.lib.discoveryclient.starter.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@AutoConfiguration
@ConditionalOnProperty(havingValue = "eureka.client.enabled", value = "true", matchIfMissing = false)
@EnableDiscoveryClient
@PropertySource(value = "classpath:application-discovery-client.properties")
public class DiscoveryClientAutoConfiguration {

}
