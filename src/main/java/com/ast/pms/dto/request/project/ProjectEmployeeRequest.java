package com.ast.pms.dto.request.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEmployeeRequest {

    private Integer employeeId; // 사원번호
    private String position; // 직급
    private Boolean isMainPm; // PM 여부
}
