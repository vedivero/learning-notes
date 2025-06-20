package com.ast.pms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "project_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private Integer personnelId; // 인력ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project; // 프로젝트ID

    @Column(name = "employee_id")
    private Integer employeeId; // 사원번호

    @Column(name = "position")
    private String position; // 직급

    @Column(name = "is_main_pm")
    private Boolean isMainPm; // PM 여부

    @Column(name = "created_at")
    private LocalDateTime createdAt; // 생성일시

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // 수정일시
}
