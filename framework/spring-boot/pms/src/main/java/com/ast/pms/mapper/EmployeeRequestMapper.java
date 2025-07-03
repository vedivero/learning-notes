package com.ast.pms.mapper;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.EmployeeLicense;
import com.ast.pms.dto.request.employee.EmployeeRequestBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRequestMapper {

    public static Employee toNewEmployee(EmployeeRequestBase request) {
        return Employee.builder()
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
    }

    public static void updateEmployeeFields(Employee employee, EmployeeRequestBase request) {
        employee.setName(request.getName());
        employee.setHeadquarter(request.getHeadquarter());
        employee.setTeam(request.getTeam());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setLevel(request.getLevel());
        employee.setPosition(request.getPosition());
        employee.setRole(request.getRole());
        employee.setWorkType(request.getWorkType());
        employee.setRemark(request.getRemark());
        employee.setUpdatedAt(LocalDateTime.now());
    }

    public static List<EmployeeLicense> toLicenseList(EmployeeRequestBase request, Employee employee) {
        if (request.getLicenses() == null || request.getLicenses().isEmpty()) {
            return List.of();
        }
        return request.getLicenses().stream()
                .map(dto -> EmployeeLicense.builder()
                        .name(dto.getName())
                        .employee(employee)
                        .createdAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }
}
