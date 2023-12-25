package com.sokima.lib.discoveryclient.starter.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@PropertySource(value = "classpath:application-discovery-client.properties")
@AutoConfiguration
public class DiscoveryClientAutoConfiguration {
}
