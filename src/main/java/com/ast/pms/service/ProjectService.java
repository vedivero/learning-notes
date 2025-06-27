package com.ast.pms.service;

import com.ast.pms.domain.*;
import com.ast.pms.dto.request.project.ProjectCreateRequest;
import com.ast.pms.dto.response.project.ProjectDetailResponse;
import com.ast.pms.dto.response.project.ProjectListResponse;
import com.ast.pms.mapper.ProjectCreateRequestMapper;
import com.ast.pms.mapper.ProjectListResponseMapper;
import com.ast.pms.repository.EmployeeRepository;
import com.ast.pms.repository.project.ProjectAttachmentRepository;
import com.ast.pms.repository.project.ProjectBudgetRepository;
import com.ast.pms.repository.project.ProjectClientRepository;
import com.ast.pms.repository.project.ProjectConsortiumRepository;
import com.ast.pms.repository.project.ProjectEmployeeRepository;
import com.ast.pms.repository.project.ProjectIssueRepository;
import com.ast.pms.repository.project.ProjectLocationRepository;
import com.ast.pms.repository.project.ProjectRepository;
import com.ast.pms.repository.project.ProjectSpecification;
import com.ast.pms.repository.project.ProjectSubcontractRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

        public void createProject(ProjectCreateRequest request) {

                Project project = ProjectCreateRequestMapper.toProject(request);
                projectRepository.save(project);

                List<ProjectBudget> budgets = ProjectCreateRequestMapper.toProjectBudgetList(request, project);
                projectBudgetRepository.saveAll(budgets);

                List<ProjectEmployee> employees = ProjectCreateRequestMapper.toProjectEmployees(request, project,
                                employeeRepository);
                projectEmployeeRepository.saveAll(employees);

                List<ProjectClient> clients = ProjectCreateRequestMapper.toProjectClients(request, project);
                projectClientRepository.saveAll(clients);

                List<ProjectSubcontract> subcontracts = ProjectCreateRequestMapper.toProjectSubcontracts(request,
                                project);
                projectSubcontractRepository.saveAll(subcontracts);

                List<ProjectConsortium> consortiums = ProjectCreateRequestMapper.toProjectConsortiums(request, project);
                projectConsortiumRepository.saveAll(consortiums);

                List<ProjectLocation> locations = ProjectCreateRequestMapper.toProjectLocations(request, project);
                projectLocationRepository.saveAll(locations);

                List<ProjectAttachment> attachments = ProjectCreateRequestMapper.toProjectAttachments(request, project);
                projectAttachmentRepository.saveAll(attachments);

                List<ProjectIssue> issues = ProjectCreateRequestMapper.toProjectIssues(request, project);
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
}
