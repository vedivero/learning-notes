package com.ast.pms.dto.response.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectLocationResponse {

    private Long id; // 식별자 (primary key)
    private String workType; // 근무형태
    private Boolean hasSharedOffice; // 합사 사무실 여부
    private String siteManager; // 현장 책임자
    private String managerContact; // 책임자 연락처

    public static ProjectLocationResponse from(com.ast.pms.domain.ProjectLocation location) {
        return ProjectLocationResponse.builder()
                .workType(location.getWorkType())
                .hasSharedOffice(location.getHasSharedOffice())
                .siteManager(location.getSiteManager())
                .managerContact(location.getManagerContact())
                .build();
    }
}
