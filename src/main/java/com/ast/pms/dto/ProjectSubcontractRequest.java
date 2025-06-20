package com.ast.pms.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectSubcontractRequest {

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
}
