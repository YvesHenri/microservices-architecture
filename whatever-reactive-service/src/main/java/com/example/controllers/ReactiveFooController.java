package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveFooController {

    @GetMapping("/foo-reactive")
    public Mono<String> foo() {
        return Mono.just("reactive foo");
    }

    @GetMapping("/public/foo-reactive")
    public Mono<String> fooPublic() {
        return Mono.just("reactive foo public");
    }

}
