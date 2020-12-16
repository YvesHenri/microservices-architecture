package com.example.facades;

import com.example.models.User;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthorizationFacade {

    private final UserService userService;

    public Mono<String> createAccessCode() {
        return Mono.just("Access code");
    }

    public Mono<String> createAccessToken() {
        Mono<User> user = userService.findByUsername("");

        // check passwords match
        // save login info
        // wrap user into a token

        return Mono.just("Access token");
    }

    public Mono<String> createAccessRefreshToken() {
        return Mono.just("Access refresh token");
    }

}
