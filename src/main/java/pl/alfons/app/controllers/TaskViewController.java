package pl.alfons.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.alfons.app.forms.TaskForm;
import pl.alfons.app.services.ProjectService;

@Slf4j
@Controller
public class TaskViewController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "wp/{id}/tt")
    public String creatingTask(Model model, @PathVariable String id) {
        model.addAttribute("task", new TaskForm());
        return "creatingTask";
    }

    @PostMapping ("wp/{id}/tt")
    public String taskSubmit(@ModelAttribute TaskForm task, @PathVariable String id) {
        System.out.println(" checkpoint 1. id: "+id);
        log.debug("lombok debug: checkpoint 1.  id: " +id);
        return "dsqadnk";
    }
}
