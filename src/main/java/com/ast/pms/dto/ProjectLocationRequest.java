package com.ast.pms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectLocationRequest {

    private String workType; // 근무형태
    private Boolean hasSharedOffice; // 합사사무실 유무
    private String siteManager; // 현장책임자
    private String managerContact; // 책임자 연락처
}
