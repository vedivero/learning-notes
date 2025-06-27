package com.ast.pms.mapper;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectEmployee;
import com.ast.pms.dto.response.project.ProjectListResponse;

public class ProjectListResponseMapper {

    public static ProjectListResponse from(Project p) {
        String pmName = p.getEmployees().stream()
                .filter(ProjectEmployee::getIsMainPm)
                .map(ProjectEmployee::getEmployee)
                .map(Employee::getName)
                .findFirst()
                .orElse(null);

        return ProjectListResponse.builder()
                .projectId(p.getProjectId())
                .projectName(p.getName())
                .pmName(pmName)
                .startDate(p.getStartDate())
                .endDate(p.getEndDate())
                .projectType(p.getProjectType())
                .status(p.getStatus())
                .build();
    }
}
