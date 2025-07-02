package com.ast.pms.dto.response.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectConsortiumResponse {

    private Long id; // 식별자 (primary key)
    private String companyName; // 회사명
    private String contractAmount; // 수주액 또는 참여 지분
    private Boolean isJointContract; // 공동계약 여부
    private Boolean isMainContract; // 주계약자 여부
    private String responsibilityRatio;// 책임 비율
    private String roleDescription; // 역할 설명

    public static ProjectConsortiumResponse from(com.ast.pms.domain.ProjectConsortium consortium) {
        return ProjectConsortiumResponse.builder()
                .companyName(consortium.getCompanyName())
                .contractAmount(consortium.getContractAmount())
                .isJointContract(consortium.getIsJointContract())
                .isMainContract(consortium.getIsMainContract())
                .responsibilityRatio(consortium.getResponsibilityRatio())
                .roleDescription(consortium.getRoleDescription())
                .build();
    }
}
