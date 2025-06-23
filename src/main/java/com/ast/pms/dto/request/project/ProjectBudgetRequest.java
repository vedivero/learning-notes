package com.ast.pms.dto.request.project;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectBudgetRequest {

    private Long totalBudget; // 사업예산총액
    private String paymentPlan; // 대금형태
    private LocalDate paymentDate; // 대금일자
    private String paymentMethod; // 지급방식
}
