package com.ast.pms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.domain.Employee;
import com.ast.pms.dto.response.EmployeeListResponse;
import com.ast.pms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeListResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
