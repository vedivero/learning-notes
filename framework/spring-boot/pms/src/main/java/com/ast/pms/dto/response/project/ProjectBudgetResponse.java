package com.ast.pms.dto.response.project;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectBudgetResponse {

    private Long id; // 예산 ID (primary key)
    private Long totalBudget; // 사업예산총액
    private String paymentPlan; // 대금형태
    private LocalDate paymentDate; // 대금일자
    private String paymentMethod; // 지급방식

    public static ProjectBudgetResponse from(com.ast.pms.domain.ProjectBudget budget) {
        return ProjectBudgetResponse.builder()
                .totalBudget(budget.getTotalBudget())
                .paymentPlan(budget.getPaymentPlan())
                .paymentDate(budget.getPaymentDate())
                .paymentMethod(budget.getPaymentMethod())
                .build();
    }
}
