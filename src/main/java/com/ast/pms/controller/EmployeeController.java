package com.ast.pms.controller;

import com.ast.pms.dto.request.EmployeeRegisterRequest;
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

    @GetMapping("/new")
    public String showRegistrationEmployeeForm(Model model) {
        model.addAttribute("employeeRegisterRequest", new EmployeeRegisterRequest());
        return "employee_register";
    }

    @PostMapping
    public String processRegister(@Valid @ModelAttribute EmployeeRegisterRequest employeeRegisterRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "employee_register";
        }
        employeeJoinService.register(employeeRegisterRequest);
        return "redirect:/login";
    }
}