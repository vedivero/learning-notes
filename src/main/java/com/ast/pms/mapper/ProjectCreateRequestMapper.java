package com.ast.pms.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.ast.pms.domain.Employee;
import com.ast.pms.domain.Project;
import com.ast.pms.domain.ProjectAttachment;
import com.ast.pms.domain.ProjectBudget;
import com.ast.pms.domain.ProjectClient;
import com.ast.pms.domain.ProjectConsortium;
import com.ast.pms.domain.ProjectEmployee;
import com.ast.pms.domain.ProjectIssue;
import com.ast.pms.domain.ProjectLocation;
import com.ast.pms.domain.ProjectSubcontract;
import com.ast.pms.dto.request.project.ProjectCreateRequest;
import com.ast.pms.dto.request.project.ProjectEmployeeRequest;
import com.ast.pms.repository.EmployeeRepository;

public class ProjectCreateRequestMapper {

    public static Project toProject(ProjectCreateRequest request) {
        return Project.builder()
                .name(request.getName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .projectType(request.getProjectType())
                .status(request.getStatus())
                .technologyType(request.getTechnologyType())
                .clientType(request.getClientType())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static List<ProjectBudget> toProjectBudgetList(ProjectCreateRequest request, Project project) {
        return request.getBudgets().stream()
                .map(b -> ProjectBudget.builder()
                        .project(project)
                        .totalBudget(b.getTotalBudget())
                        .paymentPlan(b.getPaymentPlan())
                        .paymentDate(b.getPaymentDate())
                        .paymentMethod(b.getPaymentMethod())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectEmployee> toProjectEmployees(
            ProjectCreateRequest request,
            Project project,
            EmployeeRepository employeeRepository) {
        List<ProjectEmployeeRequest> employeeRequests = request.getProjectEmployees();

        return IntStream.range(0, employeeRequests.size())
                .mapToObj(i -> {
                    ProjectEmployeeRequest e = employeeRequests.get(i);

                    Employee employee = employeeRepository.findById(e.getEmployeeId())
                            .orElseThrow(() -> new IllegalArgumentException("해당 사원이 존재하지 않습니다: " + e.getEmployeeId()));

                    return ProjectEmployee.builder()
                            .project(project)
                            .employee(employee)
                            .employeePosition(employee.getPosition())
                            .employeeRole(employee.getRole())
                            .isMainPm(i == 0) // 첫 번째 인덱스면 PM으로 설정
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public static List<ProjectClient> toProjectClients(ProjectCreateRequest request, Project project) {
        return request.getProjectClients().stream()
                .map(c -> ProjectClient.builder()
                        .project(project)
                        .organization(c.getOrganization())
                        .managerName(c.getManagerName())
                        .department(c.getDepartment())
                        .contactNumber(c.getContactNumber())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectSubcontract> toProjectSubcontracts(ProjectCreateRequest request, Project project) {
        return request.getProjectSubcontracts().stream()
                .map(s -> ProjectSubcontract.builder()
                        .project(project)
                        .companyName(s.getCompanyName())
                        .isSubcontracted(s.getIsSubcontracted())
                        .contractDate(s.getContractDate())
                        .contractStart(s.getContractStart())
                        .contractEnd(s.getContractEnd())
                        .contractCount(s.getContractCount())
                        .contractAmount(s.getContractAmount())
                        .paymentDate(s.getPaymentDate())
                        .paymentMethod(s.getPaymentMethod())
                        .isEvaluated(s.getIsEvaluated())
                        .evaluationGrade(s.getEvaluationGrade())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectConsortium> toProjectConsortiums(ProjectCreateRequest request, Project project) {
        return request.getProjectConsortiums().stream()
                .map(c -> ProjectConsortium.builder()
                        .project(project)
                        .companyName(c.getCompanyName())
                        .contractAmount(c.getContractAmount())
                        .isJointContract(c.getIsJointContract())
                        .isMainContract(c.getIsMainContract())
                        .responsibilityRatio(c.getResponsibilityRatio())
                        .roleDescription(c.getRoleDescription())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectLocation> toProjectLocations(ProjectCreateRequest request, Project project) {
        return request.getProjectLocations().stream()
                .map(l -> ProjectLocation.builder()
                        .project(project)
                        .workType(l.getWorkType())
                        .hasSharedOffice(l.getHasSharedOffice())
                        .siteManager(l.getSiteManager())
                        .managerContact(l.getManagerContact())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectAttachment> toProjectAttachments(ProjectCreateRequest request, Project project) {
        return request.getProjectAttachments().stream()
                .map(a -> ProjectAttachment.builder()
                        .project(project)
                        .fileName(a.getFileName())
                        .filePath(a.getFilePath())
                        .fileSize(a.getFileSize())
                        .fileType(a.getFileType())
                        .uploadedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ProjectIssue> toProjectIssues(ProjectCreateRequest request, Project project) {
        return request.getProjectIssues().stream()
                .map(i -> ProjectIssue.builder()
                        .project(project)
                        .issueNote(i.getIssueNote())
                        .writerId(i.getWriterId())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }
}
