package com.ast.pms.service;

import com.ast.pms.domain.*;
import com.ast.pms.dto.*;
import com.ast.pms.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

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

        public void createProject(ProjectCreateRequest request) {

                Project project = Project.builder()
                                // .projectId(request.getProjectId())
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

                projectEmployeeRepository.saveAll(
                                request.getProjectEmployees().stream()
                                                .map(e -> ProjectEmployee.builder()
                                                                .project(project)
                                                                .employeeId(e.getEmployeeId())
                                                                .position(e.getPosition())
                                                                .isMainPm(e.getIsMainPm())
                                                                .createdAt(LocalDateTime.now())
                                                                .updatedAt(LocalDateTime.now())
                                                                .build())
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
}
