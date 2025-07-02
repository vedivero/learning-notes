package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_budget")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_id")
    private Integer budgetId; // 예산ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "total_budget")
    private Long totalBudget; // 사업예산총액

    @Column(name = "payment_plan", columnDefinition = "TEXT")
    private String paymentPlan; // 대금형태

    @Column(name = "payment_date")
    private LocalDate paymentDate; // 대금일자

    @Column(name = "payment_method", columnDefinition = "TEXT")
    private String paymentMethod; // 지급방식

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시
}
