package com.ast.pms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectClientRequest {

    private String organization; // 기관명
    private String managerName; // 담당자명
    private String department; // 담당부서
    private String contactNumber; // 연락처
}
