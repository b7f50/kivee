package com.b7f50.kivee.controllers;

import com.b7f50.kivee.entities.Project;
import com.b7f50.kivee.forms.ProjectForm;
import com.b7f50.kivee.services.ProjectService;
import com.b7f50.kivee.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/project/{project_id}")
    public String view(
            Model model,
            @PathVariable(value = "project_id") String projectId) {
        Project project = projectService.getProjectById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("tasks", taskService.getOrderedTasksByProject(project));
        return "project/view";
    }

    @GetMapping(value = "/project")
    public String create(Model model) {
        model.addAttribute("projectForm", new ProjectForm());
        return "project/create";
    }

    @PostMapping("/project")
    public RedirectView create(@ModelAttribute ProjectForm projectForm) {
        Project project = projectService.saveProject(projectForm);
        return new RedirectView("/project/" + project.getId());
    }
}
