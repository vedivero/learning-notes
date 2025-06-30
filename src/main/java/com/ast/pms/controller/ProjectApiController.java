package com.ast.pms.controller;

import com.ast.pms.dto.request.project.ProjectCreateRequest;
import com.ast.pms.dto.request.project.ProjectUpdateRequest;
import com.ast.pms.dto.response.project.ProjectDetailResponse;
import com.ast.pms.dto.response.project.ProjectListResponse;
import com.ast.pms.service.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectApiController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectListResponse> getProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public ProjectDetailResponse getProjectDetail(@PathVariable("projectId") int projectId) {
        return projectService.getProjectDetailById(projectId);
    }

    @GetMapping("/search")
    public Page searchProjects(@RequestParam("keyword") String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        return projectService.searchProjects(keyword, pageable);
    }

    @PostMapping
    public ResponseEntity<String> submitProjectForm(@Valid @ModelAttribute ProjectCreateRequest projectCreateRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("입력값 검증 실패");
        }
        projectService.createProject(projectCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("프로젝트가 성공적으로 등록되었습니다.");
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<String> updateProject(
            @PathVariable("projectId") int projectId,
            @RequestBody @Valid ProjectUpdateRequest updateRequest) {

        if (projectId != updateRequest.getProjectId()) {
            return ResponseEntity.badRequest().body("요청한 ID가 일치하지 않습니다.");
        }
        projectService.updateProject(updateRequest);

        return ResponseEntity.ok("프로젝트가 성공적으로 수정되었습니다.");
    }

}