package com.ast.pms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectConsortiumRequest {

    private String companyName; // 회사명
    private String contractAmount; // 수주액 (또는 파트너 유형)
    private Boolean isJointContract; // 공동계약형태 여부
    private Boolean isMainContract; // 주계약여부
    private String responsibilityRatio; // 책임비율
    private String roleDescription; // 역할분담
}
