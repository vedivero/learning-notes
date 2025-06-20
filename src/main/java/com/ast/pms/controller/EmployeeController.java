package com.ast.pms.controller;

import com.ast.pms.dto.EmployeeJoinRequest;
import com.ast.pms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeJoinService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("employeeJoinRequest", new EmployeeJoinRequest());
        return "register";
    }

    @PostMapping
    public String processJoin(@Valid @ModelAttribute EmployeeJoinRequest employeeJoinRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        employeeJoinService.join(employeeJoinRequest);
        return "redirect:/login";
    }
}