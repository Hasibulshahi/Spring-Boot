package com.example.OAuth2;

import org.springframework.web.bind.annotation.GetMapping;

public class ApiController {
    @GetMapping("/oauth")
    public String greet() {
        return "Welcome to OAuth";
    }
}
