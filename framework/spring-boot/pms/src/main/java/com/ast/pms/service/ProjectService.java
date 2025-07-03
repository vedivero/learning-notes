package com.ast.pms.service;

import com.ast.pms.domain.*;
import com.ast.pms.dto.request.project.ProjectCreateRequest;
import com.ast.pms.dto.request.project.ProjectUpdateRequest;
import com.ast.pms.dto.response.project.ProjectDetailResponse;
import com.ast.pms.dto.response.project.ProjectListResponse;
import com.ast.pms.mapper.ProjectListResponseMapper;
import com.ast.pms.mapper.ProjectRequestMapper;
import com.ast.pms.repository.EmployeeRepository;
import com.ast.pms.repository.project.*;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

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
        private final FileStorageService fileStorageService;

        public void createProject(ProjectCreateRequest request, MultipartFile[] files) {

                Project project = ProjectRequestMapper.toProject(request);
                projectRepository.save(project);

                List<ProjectBudget> budgets = ProjectRequestMapper.toProjectBudgetList(request, project);
                projectBudgetRepository.saveAll(budgets);

                List<ProjectEmployee> employees = ProjectRequestMapper.toProjectEmployees(request, project,
                                employeeRepository);
                projectEmployeeRepository.saveAll(employees);

                List<ProjectClient> clients = ProjectRequestMapper.toProjectClients(request, project);
                projectClientRepository.saveAll(clients);

                List<ProjectSubcontract> subcontracts = ProjectRequestMapper.toProjectSubcontracts(request, project);
                projectSubcontractRepository.saveAll(subcontracts);

                List<ProjectConsortium> consortiums = ProjectRequestMapper.toProjectConsortiums(request, project);
                projectConsortiumRepository.saveAll(consortiums);

                List<ProjectLocation> locations = ProjectRequestMapper.toProjectLocations(request, project);
                projectLocationRepository.saveAll(locations);

                List<ProjectAttachment> attachments = fileStorageService.storeProejctFiles(project, files);
                projectAttachmentRepository.saveAll(attachments);

                List<ProjectIssue> issues = ProjectRequestMapper.toProjectIssues(request, project);
                projectIssueRepository.saveAll(issues);

        }

        public ProjectDetailResponse getProjectDetailById(int projectId) {
                Project project = projectRepository.findById(projectId)
                                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다. : " + projectId));

                return ProjectDetailResponse.from(project);
        }

        public List<ProjectListResponse> getAllProjects() {
                return projectRepository.findAllWithMainPm();
        }

        public Page<ProjectListResponse> searchProjects(String keyword, Pageable pageable) {
                return projectRepository.findAll(ProjectSpecification.containsKeywordInFields(keyword), pageable)
                                .map(ProjectListResponseMapper::from);
        }

        public void updateProject(ProjectUpdateRequest request) {
                Project project = projectRepository.findById(request.getProjectId())
                                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

                project.setName(request.getName());
                project.setStartDate(request.getStartDate());
                project.setEndDate(request.getEndDate());
                project.setProjectType(request.getProjectType());
                project.setStatus(request.getStatus());
                project.setTechnologyType(request.getTechnologyType());
                project.setClientType(request.getClientType());
                project.setDescription(request.getDescription());
                project.setUpdatedAt(LocalDateTime.now());

                projectBudgetRepository.deleteByProject(project);
                List<ProjectBudget> budgets = ProjectRequestMapper.toProjectBudgetList(request, project);
                projectBudgetRepository.saveAll(budgets);

                projectEmployeeRepository.deleteByProject(project);
                List<ProjectEmployee> employees = ProjectRequestMapper.toProjectEmployees(request, project,
                                employeeRepository);
                projectEmployeeRepository.saveAll(employees);

                projectClientRepository.deleteByProject(project);
                List<ProjectClient> clients = ProjectRequestMapper.toProjectClients(request, project);
                projectClientRepository.saveAll(clients);

                projectSubcontractRepository.deleteByProject(project);
                List<ProjectSubcontract> subcontracts = ProjectRequestMapper.toProjectSubcontracts(request, project);
                projectSubcontractRepository.saveAll(subcontracts);

                projectConsortiumRepository.deleteByProject(project);
                List<ProjectConsortium> consortiums = ProjectRequestMapper.toProjectConsortiums(request, project);
                projectConsortiumRepository.saveAll(consortiums);

                projectLocationRepository.deleteByProject(project);
                List<ProjectLocation> locations = ProjectRequestMapper.toProjectLocations(request, project);
                projectLocationRepository.saveAll(locations);

                projectAttachmentRepository.deleteByProject(project);
                List<ProjectAttachment> attachments = ProjectRequestMapper.toProjectAttachments(request, project);
                projectAttachmentRepository.saveAll(attachments);

                projectIssueRepository.deleteByProject(project);
                List<ProjectIssue> issues = ProjectRequestMapper.toProjectIssues(request, project);
                projectIssueRepository.saveAll(issues);
        }

}
