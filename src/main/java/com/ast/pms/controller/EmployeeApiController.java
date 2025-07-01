package com.ast.pms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.dto.request.EmployeeUpdateRequest;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<EmployeeListResponse> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("직원 목록 조회 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeDetail(@PathVariable("employeeId") int employeeId) {
        try {
            EmployeeDetailResponse response = employeeService.getEmployeeDetailById(employeeId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("직원 상세 정보 조회 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEmployees(
            @RequestParam("keyword") String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<EmployeeListResponse> result = employeeService.searchEmployees(keyword, pageable);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("직원 검색 중 오류가 발생했습니다.");
        }
    }

    @PostMapping
    public ResponseEntity<?> registerEmployee(@Valid @ModelAttribute EmployeeRegisterRequest employeeRegisterRequest,
            BindingResult bindingResult,
            Model model) {
        try {
            employeeService.registerEmployee(employeeRegisterRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("직원 정보가 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("직원 등록 중 오류가 발생했습니다.");
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("employeeId") int employeeId,
            @RequestBody @Valid EmployeeUpdateRequest updateRequest) {
        try {
            employeeService.updateProject(updateRequest);
            return ResponseEntity.ok("직원 정보가 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("직원 정보 수정 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/license/{keyword}")
    public String getLicenseName(@RequestParam String param) {
        return new String();
    }

}
