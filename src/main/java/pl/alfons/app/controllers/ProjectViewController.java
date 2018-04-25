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
import pl.alfons.app.forms.ProjectForm;
import pl.alfons.app.services.ProjectService;

@Controller
@Slf4j
public class ProjectViewController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/wp/{id}")
    public String getProject(Model model, @PathVariable String id) {
        model.addAttribute("project", projectService.getProjectById(id));
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
    public RedirectView projectSubmit(@ModelAttribute ProjectForm project) {
        Long id = projectService.saveProject(project);
        log.debug("public RedirectView projectSubmit(@ModelAttribute ProjectForm project) will return");
        return new RedirectView("/wp/" + id);
    }
}
