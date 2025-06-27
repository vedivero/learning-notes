package com.ast.pms.mapper;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.License;
import com.ast.pms.dto.response.EmployeeListResponse;

import java.util.stream.Collectors;

public class EmployeeListResponseMapper {

    public static EmployeeListResponse from(Employee e) {
        return EmployeeListResponse.builder()
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
                .licenseNames(e.getLicenses().stream()
                        .map(License::getName)
                        .collect(Collectors.toList()))
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }
}
