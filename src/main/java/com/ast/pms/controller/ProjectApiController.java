package com.ast.pms.controller;

import com.ast.pms.dto.response.project.ProjectDetailResponse;
import com.ast.pms.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectApiController {

    private final ProjectService projectService;

    @GetMapping("/{projectId}")
    public ProjectDetailResponse getProjectDetail(@PathVariable("projectId") int projectId) {
        return projectService.getProjectDetailById(projectId);
    }

}