package com.ast.pms.service;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.License;
import com.ast.pms.dto.request.EmployeeRegisterRequest;
import com.ast.pms.dto.response.EmployeeListResponse;
import com.ast.pms.repository.EmployeeRepository;
import com.ast.pms.repository.EmployeeSpecification;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

        private final EmployeeRepository employeeRepository;

        public void registerEmployee(EmployeeRegisterRequest request) {
                Employee employee = Employee.builder()
                                .email(request.getEmail())
                                .name(request.getName())
                                .headquarter(request.getHeadquarter())
                                .team(request.getTeam())
                                .hireDate(LocalDate.now())
                                .remark(request.getRemark())
                                .level(request.getLevel())
                                .position(request.getPosition())
                                .role(request.getRole())
                                .workType(request.getWorkType())
                                .status("ACTIVE")
                                .createdAt(LocalDateTime.now())
                                .build();

                if (request.getLicenses() != null && !request.getLicenses().isEmpty()) {
                        List<License> licenses = request.getLicenses().stream()
                                        .map(dto -> License.builder()
                                                        .name(dto.getName())
                                                        .employee(employee)
                                                        .createdAt(LocalDateTime.now())
                                                        .build())
                                        .toList();
                        employee.setLicenses(licenses);
                }
                employeeRepository.save(employee);
        }

        public List<EmployeeListResponse> getAllEmployees() {
                return employeeRepository.findAll().stream()
                                .map(e -> EmployeeListResponse.builder()
                                                .employeeId(e.getEmployeeId())
                                                .name(e.getName())
                                                .position(e.getPosition())
                                                .role(e.getRole())
                                                .level(e.getLevel())
                                                .workType(e.getWorkType())
                                                .team(e.getTeam())
                                                .email(e.getEmail())
                                                .phoneNumber(e.getPhoneNumber())
                                                .hireDate(e.getHireDate())
                                                .resignDate(e.getResignDate())
                                                .status(e.getStatus())
                                                .licenseNames(
                                                                e.getLicenses()
                                                                                .stream()
                                                                                .map(License::getName)
                                                                                .collect(Collectors.toList()))
                                                .createdAt(e.getCreatedAt())
                                                .updatedAt(e.getUpdatedAt())
                                                .build())
                                .collect(Collectors.toList());
        }

        public Page<EmployeeListResponse> searchEmployees(String keyword, Pageable pageable) {
                return employeeRepository.findAll(EmployeeSpecification.containsKeywordInFields(keyword), pageable)
                                .map(e -> EmployeeListResponse.builder()
                                                .employeeId(e.getEmployeeId())
                                                .name(e.getName())
                                                .position(e.getPosition())
                                                .team(e.getTeam())
                                                .workType(e.getWorkType())
                                                .email(e.getEmail())
                                                .phoneNumber(e.getPhoneNumber())
                                                .hireDate(e.getHireDate())
                                                .resignDate(e.getResignDate())
                                                .status(e.getStatus())
                                                .licenseNames(e.getLicenses().stream()
                                                                .map(License::getName)
                                                                .collect(Collectors.toList()))
                                                .createdAt(e.getCreatedAt())
                                                .updatedAt(e.getUpdatedAt())
                                                .build());
        }
}