package com.ast.pms.dto.response.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectClientResponse {

    private Long id; // 클라이언트 ID (primary key)
    private String organization; // 기관명
    private String managerName; // 담당자명
    private String department; // 부서
    private String contactNumber; // 연락처

    public static ProjectClientResponse from(com.ast.pms.domain.ProjectClient client) {
        return ProjectClientResponse.builder()
                .organization(client.getOrganization())
                .managerName(client.getManagerName())
                .department(client.getDepartment())
                .contactNumber(client.getContactNumber())
                .build();
    }
}
