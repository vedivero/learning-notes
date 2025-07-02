package com.ast.pms.dto.response.project;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.ast.pms.domain.Project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailResponse {

        private Integer projectId;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private String projectType;
        private String status;
        private String technologyType;
        private String clientType;
        private String description;

        private List<ProjectBudgetResponse> budgets;
        private List<ProjectEmployeeResponse> employees;
        private List<ProjectClientResponse> clients;
        private List<ProjectSubcontractResponse> subcontracts;
        private List<ProjectConsortiumResponse> consortiums;
        private List<ProjectLocationResponse> locations;
        private List<ProjectAttachmentResponse> attachments;
        private List<ProjectIssueResponse> issues;

        public static ProjectDetailResponse from(Project project) {
                return ProjectDetailResponse.builder()
                                .projectId(project.getProjectId())
                                .name(project.getName())
                                .startDate(project.getStartDate())
                                .endDate(project.getEndDate())
                                .projectType(project.getProjectType())
                                .status(project.getStatus())
                                .technologyType(project.getTechnologyType())
                                .clientType(project.getClientType())
                                .description(project.getDescription())

                                .budgets(project.getBudgets().stream()
                                                .map(ProjectBudgetResponse::from)
                                                .collect(Collectors.toList()))

                                .employees(project.getEmployees().stream()
                                                .map(ProjectEmployeeResponse::from)
                                                .collect(Collectors.toList()))

                                .clients(project.getClients().stream()
                                                .map(ProjectClientResponse::from)
                                                .collect(Collectors.toList()))

                                .subcontracts(project.getSubcontracts().stream()
                                                .map(ProjectSubcontractResponse::from)
                                                .collect(Collectors.toList()))

                                .consortiums(project.getConsortiums().stream()
                                                .map(ProjectConsortiumResponse::from)
                                                .collect(Collectors.toList()))

                                .locations(project.getLocations().stream()
                                                .map(ProjectLocationResponse::from)
                                                .collect(Collectors.toList()))

                                .attachments(project.getAttachments().stream()
                                                .map(ProjectAttachmentResponse::from)
                                                .collect(Collectors.toList()))

                                .issues(project.getIssues().stream()
                                                .map(ProjectIssueResponse::from)
                                                .collect(Collectors.toList()))

                                .build();
        }
}
