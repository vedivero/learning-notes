package com.ast.pms.dto.response.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEmployeeResponse {

    private Long id; // 식별자 (primary key)
    private Integer employeeId; // 사원번호
    private String position; // 직급
    private Boolean isMainPm; // PM 여부

    public static ProjectEmployeeResponse from(com.ast.pms.domain.ProjectEmployee employee) {
        return ProjectEmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .position(employee.getPosition())
                .isMainPm(employee.getIsMainPm())
                .build();
    }
}
