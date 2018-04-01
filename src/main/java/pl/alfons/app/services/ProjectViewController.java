package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectViewController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/wp/{id}")
    public String getProject(Model model, @PathVariable String id) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project";
    }

    @GetMapping(value = "/tp")
    public String creatingProject() {
        return "creatingProject";
    }
}
