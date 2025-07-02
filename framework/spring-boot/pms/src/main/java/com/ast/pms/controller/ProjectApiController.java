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
    public ResponseEntity<?> getProjects() {
        try {
            List<ProjectListResponse> projects = projectService.getAllProjects();
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("프로젝트 목록 조회 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectDetail(@PathVariable("projectId") int projectId) {
        try {
            ProjectDetailResponse response = projectService.getProjectDetailById(projectId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("프로젝트 상세 조회 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProjects(
            @RequestParam("keyword") String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<ProjectListResponse> result = projectService.searchProjects(keyword, pageable);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("프로젝트 검색 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> submitProjectForm(@Valid @ModelAttribute ProjectCreateRequest projectCreateRequest,
            BindingResult bindingResult,
            Model model) {
        try {
            projectService.createProject(projectCreateRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("프로젝트가 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("프로젝트 등록 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProject(
            @PathVariable("projectId") int projectId,
            @RequestBody @Valid ProjectUpdateRequest updateRequest) {
        try {
            projectService.updateProject(updateRequest);
            return ResponseEntity.ok("프로젝트가 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("프로젝트 수정 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }

}
