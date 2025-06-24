package com.ast.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ast.pms.dto.request.AccountRegisterRequest;
import com.ast.pms.service.AccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String getMethodName(Model model) {
        model.addAttribute("accountRegisterRequest", new AccountRegisterRequest());
        return "account_register";
    }

    @PostMapping
    public String postMethodName(@Valid @ModelAttribute AccountRegisterRequest accountRegisterRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "account_register";
        }
        accountService.register(accountRegisterRequest);
        return "redirect:/main";
    }

}
