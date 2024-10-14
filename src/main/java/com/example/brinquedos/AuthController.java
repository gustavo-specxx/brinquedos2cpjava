package com.example.brinquedos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "auth/login"; // Thymeleaf template for login
    }

    // Página de Sign Up
    @GetMapping("/signup")
    public String signup() {
        return "auth/signup"; // Thymeleaf template for sign up
    }
}
