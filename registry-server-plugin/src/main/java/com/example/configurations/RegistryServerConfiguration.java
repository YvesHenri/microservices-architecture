package com.example.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "spring.cloud.server.registry", havingValue = "true")
public class RegistryServerConfiguration {



}
