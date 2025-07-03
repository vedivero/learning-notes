package com.ast.pms.mapper;

import com.ast.pms.domain.*;
import com.ast.pms.dto.request.project.ProjectRequestBase;
import com.ast.pms.dto.request.project.ProjectEmployeeRequest;
import com.ast.pms.repository.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProjectRequestMapper {

        public static Project toProject(ProjectRequestBase request) {
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

        /**
         * 예산 리스트 생성
         */
        public static List<ProjectBudget> toProjectBudgetList(ProjectRequestBase request, Project project) {
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

        /**
         * 인력 리스트 생성
         */
        public static List<ProjectEmployee> toProjectEmployees(ProjectRequestBase request, Project project,
                        EmployeeRepository employeeRepository) {
                List<ProjectEmployeeRequest> employeeRequests = request.getProjectEmployees();

                return IntStream.range(0, employeeRequests.size())
                                .mapToObj(i -> {
                                        ProjectEmployeeRequest e = employeeRequests.get(i);

                                        Employee employee = employeeRepository.findById(e.getEmployeeId())
                                                        .orElseThrow(() -> new IllegalArgumentException(
                                                                        "해당 사원이 존재하지 않습니다: " + e.getEmployeeId()));

                                        return ProjectEmployee.builder()
                                                        .project(project)
                                                        .employee(employee)
                                                        .employeePosition(employee.getPosition())
                                                        .employeeRole(employee.getRole())
                                                        .isMainPm(i == 0)
                                                        .createdAt(LocalDateTime.now())
                                                        .updatedAt(LocalDateTime.now())
                                                        .build();
                                })
                                .collect(Collectors.toList());
        }

        /**
         * 발주처 리스트 생성
         */
        public static List<ProjectClient> toProjectClients(ProjectRequestBase request, Project project) {
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

        /**
         * 하도급 리스트 생성
         */
        public static List<ProjectSubcontract> toProjectSubcontracts(ProjectRequestBase request, Project project) {
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

        /**
         * 컨소시움 리스트 생성
         */
        public static List<ProjectConsortium> toProjectConsortiums(ProjectRequestBase request, Project project) {
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

        /**
         * 수행 장소 리스트 생성
         */
        public static List<ProjectLocation> toProjectLocations(ProjectRequestBase request, Project project) {
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

        /**
         * 첨부 파일 리스트 생성
         */
        public static List<ProjectAttachment> toProjectAttachments(ProjectRequestBase request, Project project) {
                if (request.getProjectAttachments() == null) {
                        return List.of();
                }
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

        /**
         * 이슈 리스트 생성
         */
        public static List<ProjectIssue> toProjectIssues(ProjectRequestBase request, Project project) {
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
