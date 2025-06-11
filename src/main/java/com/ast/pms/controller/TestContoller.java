package com.ast.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {

    @GetMapping("/main/test")
    public String getMethodName() {
        return "login";
    }

}
