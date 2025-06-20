package com.ast.pms.service;

import com.ast.pms.domain.Employee;
import com.ast.pms.dto.EmployeeJoinRequest;
import com.ast.pms.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(EmployeeJoinRequest request) {
        Employee employee = Employee.builder()
                .loginId(request.getLoginId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .headquarter(request.getHeadquarter())
                .team(request.getTeam())
                .hireDate(LocalDate.now())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .role(request.getRole())
                .gender(request.getGender())
                .status("ACTIVE")
                .accountEnabled(true)
                .createdAt(LocalDateTime.now())
                .build();

        employeeRepository.save(employee);
    }
}
