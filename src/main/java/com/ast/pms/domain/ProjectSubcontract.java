package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "subcontract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectSubcontract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcontract_id")
    private Integer subcontractId; // 하도급ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "company_name")
    private String companyName; // 업체명

    @Column(name = "is_subcontracted")
    private Boolean isSubcontracted; // 하도급여부

    @Column(name = "contract_date")
    private LocalDate contractDate; // 계약일자

    @Column(name = "contract_start")
    private LocalDate contractStart; // 계약시작일

    @Column(name = "contract_end")
    private LocalDate contractEnd; // 계약종료일

    @Column(name = "contract_count")
    private Integer contractCount; // 계약건수

    @Column(name = "contract_amount")
    private Long contractAmount; // 계약금액

    @Column(name = "payment_date")
    private LocalDate paymentDate; // 대금지급일자

    @Column(name = "payment_method", columnDefinition = "TEXT")
    private String paymentMethod; // 지급방식

    @Column(name = "is_evaluated")
    private Boolean isEvaluated; // 평가여부

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시
}
