package com.sokima.paas.mic.hex.apigateway.infra.config;

import com.sokima.paas.mic.hex.apigateway.domain.model.ApiGatewayModel;
import com.sokima.paas.mic.hex.apigateway.usecase.ApiGatewayUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayUseCaseConfiguration {

    @Bean
    ApiGatewayUseCase apiGatewayUseCase() {
        return () -> new ApiGatewayModel() {
        };
    }
}
