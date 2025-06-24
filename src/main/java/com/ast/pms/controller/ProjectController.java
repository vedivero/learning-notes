package com.ast.pms.controller;

import com.ast.pms.dto.request.ProjectCreateRequest;
import com.ast.pms.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/new")
    public String showProjectCreateForm(Model model) {
        model.addAttribute("projectCreateRequest", new ProjectCreateRequest());
        return "project";
    }

    @PostMapping
    public String submitProjectForm(@Valid @ModelAttribute ProjectCreateRequest projectCreateRequest,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "project/new";
        }
        projectService.createProject(projectCreateRequest);
        return "redirect:/main";
    }

}