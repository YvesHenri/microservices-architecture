package com.example.controllers;

import com.example.facades.AuthorizationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationFacade facade;

    @GetMapping("/auth/jwk")
    public Mono<String> retrieveJwk() {
        return Mono.just("");
    }

    @GetMapping("/auth/code")
    public Mono<String> createAccessCode() {
        return facade.createAccessCode();
    }

    @PostMapping("/auth/token")
    public Mono<String> createAccessToken() {
        return facade.createAccessToken();
    }

    @PostMapping("/auth/token/refresh")
    public Mono<String> createAccessRefreshToken() {
        return facade.createAccessRefreshToken();
    }

}
