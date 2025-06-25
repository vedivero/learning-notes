package com.ast.pms.service;

import com.ast.pms.domain.*;
import com.ast.pms.dto.request.project.ProjectCreateRequest;
import com.ast.pms.dto.request.project.ProjectEmployeeRequest;
import com.ast.pms.dto.response.project.ProjectDetailResponse;
import com.ast.pms.dto.response.project.ProjectListResponse;
import com.ast.pms.repository.EmployeeRepository;
import com.ast.pms.repository.project.ProjectAttachmentRepository;
import com.ast.pms.repository.project.ProjectBudgetRepository;
import com.ast.pms.repository.project.ProjectClientRepository;
import com.ast.pms.repository.project.ProjectConsortiumRepository;
import com.ast.pms.repository.project.ProjectEmployeeRepository;
import com.ast.pms.repository.project.ProjectIssueRepository;
import com.ast.pms.repository.project.ProjectLocationRepository;
import com.ast.pms.repository.project.ProjectRepository;
import com.ast.pms.repository.project.ProjectSubcontractRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

        private final ProjectRepository projectRepository;
        private final ProjectBudgetRepository projectBudgetRepository;
        private final ProjectEmployeeRepository projectEmployeeRepository;
        private final ProjectClientRepository projectClientRepository;
        private final ProjectSubcontractRepository projectSubcontractRepository;
        private final ProjectConsortiumRepository projectConsortiumRepository;
        private final ProjectLocationRepository projectLocationRepository;
        private final ProjectAttachmentRepository projectAttachmentRepository;
        private final ProjectIssueRepository projectIssueRepository;
        private final EmployeeRepository employeeRepository;

        public void createProject(ProjectCreateRequest request) {

                Project project = Project.builder()
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

                projectRepository.save(project);

                projectBudgetRepository.saveAll(
                                request.getBudgets().stream()
                                                .map(b -> ProjectBudget.builder()
                                                                .project(project)
                                                                .totalBudget(b.getTotalBudget())
                                                                .paymentPlan(b.getPaymentPlan())
                                                                .paymentDate(b.getPaymentDate())
                                                                .paymentMethod(b.getPaymentMethod())
                                                                .createdAt(LocalDateTime.now())
                                                                .updatedAt(LocalDateTime.now())
                                                                .build())
                                                .collect(Collectors.toList()));

                List<ProjectEmployeeRequest> employeeRequests = request.getProjectEmployees();

                projectEmployeeRepository.saveAll(
                                IntStream.range(0, employeeRequests.size())
                                                .mapToObj(i -> {
                                                        ProjectEmployeeRequest e = employeeRequests.get(i);

                                                        Employee employee = employeeRepository
                                                                        .findById(e.getEmployeeId())
                                                                        .orElseThrow(() -> new IllegalArgumentException(
                                                                                        "해당 사원이 존재하지 않습니다: " + e
                                                                                                        .getEmployeeId()));

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
                                                .collect(Collectors.toList()));

                projectClientRepository.saveAll(
                                request.getProjectClients().stream()
                                                .map(c -> ProjectClient.builder()
                                                                .project(project)
                                                                .organization(c.getOrganization())
                                                                .managerName(c.getManagerName())
                                                                .department(c.getDepartment())
                                                                .contactNumber(c.getContactNumber())
                                                                .createdAt(LocalDateTime.now())
                                                                .updatedAt(LocalDateTime.now())
                                                                .build())
                                                .collect(Collectors.toList()));

                projectSubcontractRepository.saveAll(
                                request.getProjectSubcontracts().stream()
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
                                                .collect(Collectors.toList()));

                projectConsortiumRepository.saveAll(
                                request.getProjectConsortiums().stream()
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
                                                .collect(Collectors.toList()));

                projectLocationRepository.saveAll(
                                request.getProjectLocations().stream()
                                                .map(l -> ProjectLocation.builder()
                                                                .project(project)
                                                                .workType(l.getWorkType())
                                                                .hasSharedOffice(l.getHasSharedOffice())
                                                                .siteManager(l.getSiteManager())
                                                                .managerContact(l.getManagerContact())
                                                                .createdAt(LocalDateTime.now())
                                                                .updatedAt(LocalDateTime.now())
                                                                .build())
                                                .collect(Collectors.toList()));

                projectAttachmentRepository.saveAll(
                                request.getProjectAttachments().stream()
                                                .map(a -> ProjectAttachment.builder()
                                                                .project(project)
                                                                .fileName(a.getFileName())
                                                                .filePath(a.getFilePath())
                                                                .fileSize(a.getFileSize())
                                                                .fileType(a.getFileType())
                                                                .uploadedAt(LocalDateTime.now())
                                                                .build())
                                                .collect(Collectors.toList()));

                projectIssueRepository.saveAll(
                                request.getProjectIssues().stream()
                                                .map(i -> ProjectIssue.builder()
                                                                .project(project)
                                                                .issueNote(i.getIssueNote())
                                                                .writerId(i.getWriterId())
                                                                .createdAt(LocalDateTime.now())
                                                                .updatedAt(LocalDateTime.now())
                                                                .build())
                                                .collect(Collectors.toList()));
        }

        public ProjectDetailResponse getProjectDetailById(int projectId) {
                Project project = projectRepository.findById(projectId)
                                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다. : " + projectId));

                return ProjectDetailResponse.from(project);
        }

        public List<ProjectListResponse> getAllProjects() {
                return projectRepository.findAllWithMainPm();
        }
}
