package com.example.OAuth2;

import org.springframework.web.bind.annotation.GetMapping;

public class ApiController {
    @GetMapping("/")
    public String greet() {
        return "Welcome to Telusko, telusko.com";
    }
}
