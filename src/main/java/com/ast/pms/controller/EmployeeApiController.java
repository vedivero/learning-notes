package com.ast.pms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.dto.response.EmployeeDetailResponse;
import com.ast.pms.dto.response.EmployeeListResponse;
import com.ast.pms.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/{employeeId}")
    public EmployeeDetailResponse getEmployeeDetail(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployeeDetailById(employeeId);
    }

    @GetMapping("/search")
    public Page<EmployeeListResponse> searchEmployees(
            @RequestParam("keyword") String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        return employeeService.searchEmployees(keyword, pageable);
    }

    @PostMapping
    public ResponseEntity registerEmployee(@Valid @ModelAttribute EmployeeRegisterRequest employeeRegisterRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("입력값 검증 실패");
        }
        employeeService.registerEmployee(employeeRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("직원 정보가 성공적으로 등록되었습니다.");
    }

}
