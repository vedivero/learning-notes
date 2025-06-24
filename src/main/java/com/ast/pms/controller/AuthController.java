package com.ast.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping
    public String showLoginForm() {
        return "login";
    }

}
