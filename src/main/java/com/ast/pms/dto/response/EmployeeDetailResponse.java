package com.ast.pms.dto.response;

import com.ast.pms.domain.Employee;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetailResponse {

    private Integer employeeId;
    private String email;
    private String name;
    private String headquarter;
    private String team;
    private LocalDate hireDate;
    private LocalDate resignDate;
    private String position;
    private String level;
    private String workType;
    private String phoneNumber;
    private String extension;
    private String status;
    private String role;
    private String remark;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<LicenseResponse> licenses;

    public static EmployeeDetailResponse from(Employee e) {
        return EmployeeDetailResponse.builder()
                .employeeId(e.getEmployeeId())
                .email(e.getEmail())
                .name(e.getName())
                .headquarter(e.getHeadquarter())
                .team(e.getTeam())
                .hireDate(e.getHireDate())
                .resignDate(e.getResignDate())
                .position(e.getPosition())
                .level(e.getLevel())
                .workType(e.getWorkType())
                .phoneNumber(e.getPhoneNumber())
                .extension(e.getExtension())
                .status(e.getStatus())
                .role(e.getRole())
                .remark(e.getRemark())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .licenses(
                        e.getLicenses().stream()
                                .map(LicenseResponse::from)
                                .collect(Collectors.toList()))
                .build();
    }
}
