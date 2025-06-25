package com.ast.pms.dto.response.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ProjectListResponse {

    private Integer projectId; // 프로젝트 ID
    private String projectName; // 프로젝트 이름
    private String pmName; // 담당 PM 이름 (is_main_pm = true)
    private LocalDate startDate; // 시작일
    private LocalDate endDate; // 종료일
    private String projectType; // 사업유형
    private String status; // 상태
}
