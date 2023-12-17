package com.sokima.paas.mic.hex.discovery.infra.config;

import com.sokima.paas.mic.hex.discovery.domain.model.DiscoveryModel;
import com.sokima.paas.mic.hex.discovery.usecase.DiscoveryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscoveryUseCaseConfiguration {

    @Bean
    DiscoveryUseCase discoveryUseCase() {
        return () -> new DiscoveryModel() {
        };
    }
}
