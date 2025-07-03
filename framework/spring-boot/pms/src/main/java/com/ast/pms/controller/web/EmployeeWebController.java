package com.ast.pms.controller.web;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ast.pms.dto.request.employee.EmployeeRegisterRequest;

import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeWebController {

    @GetMapping("/new")
    public String showRegistrationEmployeeForm(Model model) {
        model.addAttribute("employeeRegisterRequest", new EmployeeRegisterRequest());
        return "employee_register";
    }

}