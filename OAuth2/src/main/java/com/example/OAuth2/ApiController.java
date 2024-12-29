package com.example.OAuth2;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ApiController {
    @GetMapping("/oauth")
    public String greet() {
        return "Welcome to OAuth";
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser principal, Model model) {
//        if (principal != null) {
//            model.addAttribute("user", principal);
//        }
        return "Welcome to OAuth"; // Ensure "home.html" exists in `src/main/resources/templates`
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:https://dev-1idbplxpxvks61k8.us.auth0.com/v2/logout?client_id=8LxfKyYuH5kTVzQsSHFaRNmYHJvRBmEk&returnTo=http://localhost:8080";
    }
}
