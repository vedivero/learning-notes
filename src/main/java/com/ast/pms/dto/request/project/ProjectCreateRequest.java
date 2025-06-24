package com.ast.pms.dto.request.project;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateRequest {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectType;
    private String status;
    private String technologyType;
    private String clientType;
    private String description;

    private List<ProjectBudgetRequest> budgets;
    private List<ProjectEmployeeRequest> projectEmployees;
    private List<ProjectClientRequest> projectClients;
    private List<ProjectSubcontractRequest> projectSubcontracts;
    private List<ProjectConsortiumRequest> projectConsortiums;
    private List<ProjectLocationRequest> projectLocations;
    private List<ProjectAttachmentRequest> projectAttachments;
    private List<ProjectIssueRequest> projectIssues;
}
