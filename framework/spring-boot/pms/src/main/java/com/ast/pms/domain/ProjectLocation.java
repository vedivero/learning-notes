package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "project_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer placeId; // 장소ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "work_type")
    private String workType; // 근무형태

    @Column(name = "has_shared_office")
    private Boolean hasSharedOffice; // 합사사무실유무

    @Column(name = "site_manager")
    private String siteManager; // 현장책임자

    @Column(name = "manager_contact")
    private String managerContact; // 책임자연락처

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시
}
