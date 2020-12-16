package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @GetMapping("/foo")
    public String foo() {
        return "foo";
    }

    @GetMapping("/public/foo")
    public String fooPublic() {
        return "foo public";
    }

}
