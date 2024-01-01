package com.sokima.paas.mic.hex.apigateway.infra.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouteLocator routeLocator(final RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "mic-hex-eims-route",
                        route -> route.path(
                                        "/mic-hex-eims/**"
                                )
                                .uri("http://localhost:8000")
                )
                .route(
                        "mic-hex-eoms-route",
                        route -> route.path(
                                        "/mic-hex-eoms/**"
                                )
                                .uri("http://localhost:8100")
                )
                .route(
                        "mic-hex-epcs-route",
                        route -> route.path(
                                        "/mic-hex-epcs/**"
                                )
                                .uri("http://localhost:8200")
                )
                .route(
                        "mic-hex-epgs-route",
                        route -> route.path(
                                        "/mic-hex-epgs/**"
                                )
                                .uri("http://localhost:8300")
                )
                .route(
                        "mic-hex-escs-route",
                        route -> route.path(
                                        "/mic-hex-escs/**"
                                )
                                .uri("http://localhost:8400")
                )
                .route(
                        "mic-hex-eums-route",
                        route -> route.path(
                                        "/mic-hex-eums/**"
                                )
                                .uri("http://localhost:8500")
                )
                .build();
    }
}
