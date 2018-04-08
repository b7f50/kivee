package pl.alfons.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.alfons.app.entities.Project;
import pl.alfons.app.services.ProjectService;

@Controller
public class ProjectViewController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/wp/{id}")
    public String getProject(Model model, @PathVariable String id) {
        model.addAttribute("project", projectService.getProjectById(id)); // co robi ten pierwszy project?
        return "project";
    }

    @GetMapping(value = "/tp")
    public String creatingProject(Model model) {
        model.addAttribute("project", new Project());
        return "creatingProject";
    }

    @PostMapping("/tp")
    public String projectSubmit(@ModelAttribute Project project) {
       projectService.saveProject(project);
        return "project";
    }
}
