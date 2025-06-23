package com.ast.pms.dto.request.project;

import java.time.LocalDate;
import java.util.List;

import com.ast.pms.domain.ProjectAttachment;
import com.ast.pms.domain.ProjectBudget;
import com.ast.pms.domain.ProjectClient;
import com.ast.pms.domain.ProjectConsortium;
import com.ast.pms.domain.ProjectEmployee;
import com.ast.pms.domain.ProjectIssue;
import com.ast.pms.domain.ProjectLocation;
import com.ast.pms.domain.ProjectSubcontract;

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

    private List<ProjectBudget> budgets;
    private List<ProjectEmployee> projectEmployees;
    private List<ProjectClient> projectClients;
    private List<ProjectSubcontract> projectSubcontracts;
    private List<ProjectConsortium> projectConsortiums;
    private List<ProjectLocation> projectLocations;
    private List<ProjectAttachment> projectAttachments;
    private List<ProjectIssue> projectIssues;
}
