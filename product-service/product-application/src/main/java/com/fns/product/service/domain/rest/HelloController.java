package com.fns.product.service.domain.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}