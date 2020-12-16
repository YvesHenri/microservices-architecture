package com.example.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

// https://spring.io/projects/spring-cloud-gateway
@ConditionalOnProperty(value = "ENABLE_GATEWAY", havingValue = "true")
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        // TODO Perhaps change URL pattern to service/public/** instead
        return builder.routes()
                .route(route -> route.path("/bar/**").uri("http://localhost:8001").id("bar"))
                .route(route -> route.path("/public/bar/**").uri("http://localhost:8001").id("bar-p"))
                .route(route -> route.path("/foo/**").uri("http://localhost:8001").id("foo"))
                .route(route -> route.path("/public/foo/**").uri("http://localhost:8001").id("foo-p"))
                .route(route -> route.path("/bar-reactive/**").uri("http://localhost:8002").id("bar-r"))
                .route(route -> route.path("/public/bar-reactive/**").uri("http://localhost:8002").id("bar-p-r"))
                .route(route -> route.path("/foo-reactive/**").uri("http://localhost:8002").id("foo-r"))
                .route(route -> route.path("/public/foo-reactive/**").uri("http://localhost:8002").id("foo-p-r"))
                .build();
    }

}
