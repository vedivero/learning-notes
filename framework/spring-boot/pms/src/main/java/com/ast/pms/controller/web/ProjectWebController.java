package com.ast.pms.controller.web;

import com.ast.pms.dto.request.project.ProjectCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectWebController {

    @GetMapping("/new")
    public String showProjectCreateForm(Model model) {
        model.addAttribute("projectCreateRequest", new ProjectCreateRequest());
        return "project";
    }

}