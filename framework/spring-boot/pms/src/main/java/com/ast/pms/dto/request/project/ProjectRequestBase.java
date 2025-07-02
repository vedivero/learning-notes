package com.ast.pms.dto.request.project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRequestBase {
    String getName();

    LocalDate getStartDate();

    LocalDate getEndDate();

    String getProjectType();

    String getStatus();

    String getTechnologyType();

    String getClientType();

    String getDescription();

    List<ProjectBudgetRequest> getBudgets();

    List<ProjectEmployeeRequest> getProjectEmployees();

    List<ProjectClientRequest> getProjectClients();

    List<ProjectSubcontractRequest> getProjectSubcontracts();

    List<ProjectConsortiumRequest> getProjectConsortiums();

    List<ProjectLocationRequest> getProjectLocations();

    List<ProjectAttachmentRequest> getProjectAttachments();

    List<ProjectIssueRequest> getProjectIssues();
}
