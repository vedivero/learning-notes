package com.ast.pms.service;

import com.ast.pms.domain.Employee;
import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void register(EmployeeRegisterRequest request) {
        Employee employee = Employee.builder()
                .email(request.getEmail())
                .name(request.getName())
                .headquarter(request.getHeadquarter())
                .team(request.getTeam())
                .hireDate(LocalDate.now())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .role(request.getRole())
                .status("ACTIVE")
                .createdAt(LocalDateTime.now())
                .build();

        employeeRepository.save(employee);
    }
}
