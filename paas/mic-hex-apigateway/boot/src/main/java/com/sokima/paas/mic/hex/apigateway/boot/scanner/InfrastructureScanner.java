package com.sokima.paas.mic.hex.apigateway.boot.scanner;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-infra.properties")
@ComponentScan("com.sokima.paas.mic.hex.apigateway.infra")
public class InfrastructureScanner {
}
