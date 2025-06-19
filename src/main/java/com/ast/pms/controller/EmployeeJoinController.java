package com.ast.pms.controller;

import com.ast.pms.dto.EmployeeJoinRequest;
import com.ast.pms.service.EmployeeJoinService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/join")
public class EmployeeJoinController {

    private final EmployeeJoinService employeeJoinService;

    @GetMapping
    public String showJoinForm(Model model) {
        model.addAttribute("employeeJoinRequest", new EmployeeJoinRequest());
        return "join";
    }

    @PostMapping
    public String processJoin(@Valid @ModelAttribute EmployeeJoinRequest employeeJoinRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "join";
        }
        employeeJoinService.join(employeeJoinRequest);
        return "redirect:/login";
    }
}
