package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveBarController {

    @GetMapping("/bar-reactive")
    public Mono<String> bar() {
        return Mono.just("reactive bar");
    }

    @GetMapping("/public/bar-reactive")
    public Mono<String> barPublic() {
        return Mono.just("reactive bar public");
    }

}
