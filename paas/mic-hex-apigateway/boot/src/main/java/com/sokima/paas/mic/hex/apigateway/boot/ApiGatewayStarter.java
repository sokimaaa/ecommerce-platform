package com.sokima.paas.mic.hex.apigateway.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayStarter.class, args);
    }
}
