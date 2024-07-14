package org.diecastfinder.scggateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localhostConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
            .route(crawler -> crawler.path("/api/v1/crawler/*")
                .uri("http://localhost:8083"))
            .route(catalog -> catalog.path("/api/v1/catalog*", "/api/v1/catalog/*")
                .uri("http://localhost:8086"))
            .build();
    }
}
