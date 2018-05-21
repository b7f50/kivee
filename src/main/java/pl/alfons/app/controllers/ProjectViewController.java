package pl.alfons.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.alfons.app.entities.Project;
import pl.alfons.app.forms.ProjectForm;
import pl.alfons.app.services.ProjectService;
import pl.alfons.app.services.TaskService;

@Controller
@Slf4j
public class ProjectViewController {

    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/wp/{id}")
    public String getProject(Model model, @PathVariable String id) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        model.addAttribute("tasks", taskService.getTasksByProject(project));
        log.debug("public String getProject(Model model, @PathVariable String id) will return");
        return "project";
    }

    @GetMapping(value = "/tp")
    public String creatingProject(Model model) {
        model.addAttribute("project", new ProjectForm());
        log.debug("public String creatingProject(Model model) will return");
        return "creatingProject";
    }

    @PostMapping("/tp")
    public RedirectView projectSubmit(@ModelAttribute ProjectForm projectForm) {
        Project project = projectService.saveProject(projectForm);
        log.debug("public RedirectView projectSubmit(@ModelAttribute ProjectForm project) will return");
        return new RedirectView("/wp/" + project.getId());
    }
}
