package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId; // 프로젝트ID

    @Column(name = "name")
    private String name; // 사업명

    @Column(name = "start_date")
    private LocalDate startDate; // 시작일

    @Column(name = "end_date")
    private LocalDate endDate; // 종료일

    @Column(name = "project_type")
    private String projectType; // 사업유형

    @Column(name = "status")
    private String status; // 진행상태

    @Column(name = "technology_type")
    private String technologyType; // 기술분류

    @Column(name = "client_type")
    private String clientType; // 고객유형

    @Column(name = "description", columnDefinition = "TEXT")
    private String description; // 프로젝트설명

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시

    // 프로젠트 인력
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectEmployee> employees = new ArrayList<>();

    // 예산
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectBudget> budgets = new ArrayList<>();

    // 하도급
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectSubcontract> subcontracts = new ArrayList<>();

    // 발주처
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectClient> clients = new ArrayList<>();

    // 컨소시움
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectConsortium> consortiums = new ArrayList<>();

    // 수행 장소
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectLocation> locations = new ArrayList<>();

    // 첨부 파일
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectAttachment> attachments = new ArrayList<>();

    // 이슈
    @Builder.Default
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectIssue> issues = new ArrayList<>();

}
