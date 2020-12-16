package com.example.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@ConditionalOnProperty(value = "spring.cloud.server.resource", havingValue = "true")
public class ResourceServerConfiguration {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http
            .cors().disable()
            .csrf().disable()
            .oauth2ResourceServer(configurer -> configurer.jwt())
            .authorizeExchange(configurer -> configurer
                .pathMatchers("/auth/**").permitAll()
                .pathMatchers("/public/**").permitAll()
                .anyExchange().authenticated()
            );

        return http.build();
    }

//    @Bean
//    public ReactiveJwtDecoder jwtDecoder(RSAPublicKey rsaPublicKey) {
//        return NimbusReactiveJwtDecoder.withPublicKey(rsaPublicKey).build();
//    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter());
        return jwtAuthenticationConverter;
    }

    private JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthorityPrefix("SCOPE_");
        converter.setAuthoritiesClaimName("scopes");
        return converter;
    }

}
