package com.ast.pms.dto.response.project;

import com.ast.pms.domain.ProjectEmployee;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEmployeeResponse {

    private Integer personnelId;
    private Integer employeeId;
    private String position;
    private String role;
    private Boolean isMainPm;

    public static ProjectEmployeeResponse from(ProjectEmployee entity) {
        return ProjectEmployeeResponse.builder()
                .personnelId(entity.getPersonnelId())
                .employeeId(entity.getEmployee().getEmployeeId())
                .position(entity.getEmployeePosition())
                .role(entity.getEmployeeRole())
                .isMainPm(entity.getIsMainPm())
                .build();
    }
}
