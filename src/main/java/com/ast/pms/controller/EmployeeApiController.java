package com.ast.pms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.dto.response.EmployeeListResponse;
import com.ast.pms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeListResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/search")
    public Page<EmployeeListResponse> searchEmployees(
            @RequestParam("keyword") String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        return employeeService.searchEmployees(keyword, pageable);
    }

}
