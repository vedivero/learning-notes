package com.ast.pms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/auth")
public class AuthWebController {

    @GetMapping
    public String showLoginForm() {
        return "login";
    }

}
