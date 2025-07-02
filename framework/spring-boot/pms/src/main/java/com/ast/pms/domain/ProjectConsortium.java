package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "project_consortium")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectConsortium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consortium_id")
    private Integer consortiumId; // 컨소시엄ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "company_name")
    private String companyName; // 회사명

    @Column(name = "contract_amount")
    private String contractAmount; // 수주액

    @Column(name = "is_joint_contract")
    private Boolean isJointContract; // 공동계약형태

    @Column(name = "is_main_contract")
    private Boolean isMainContract; // 주계약여부

    @Column(name = "responsibility_ratio")
    private String responsibilityRatio; // 책임비율

    @Column(name = "role_description")
    private String roleDescription; // 역할분담

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시
}
