package com.ast.pms.dto.response.project;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectSubcontractResponse {

    private Long id; // 식별자 (primary key)
    private String companyName; // 업체명
    private Boolean isSubcontracted; // 하도급 여부
    private LocalDate contractDate; // 계약일자
    private LocalDate contractStart; // 계약시작일
    private LocalDate contractEnd; // 계약종료일
    private Integer contractCount; // 계약건수
    private Long contractAmount; // 계약금액
    private LocalDate paymentDate; // 대금지급일자
    private String paymentMethod; // 지급방식
    private Boolean isEvaluated; // 평가여부

    public static ProjectSubcontractResponse from(com.ast.pms.domain.ProjectSubcontract subcontract) {
        return ProjectSubcontractResponse.builder()
                .companyName(subcontract.getCompanyName())
                .isSubcontracted(subcontract.getIsSubcontracted())
                .contractDate(subcontract.getContractDate())
                .contractStart(subcontract.getContractStart())
                .contractEnd(subcontract.getContractEnd())
                .contractCount(subcontract.getContractCount())
                .contractAmount(subcontract.getContractAmount())
                .paymentDate(subcontract.getPaymentDate())
                .paymentMethod(subcontract.getPaymentMethod())
                .isEvaluated(subcontract.getIsEvaluated())
                .build();
    }
}
