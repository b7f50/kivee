package pl.alfons.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.alfons.app.forms.TaskForm;
import pl.alfons.app.services.ProjectService;

@Controller
public class TaskViewController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "wp/{id}/tt")
    public String creatingTask (Model model, @PathVariable String id){
        model.addAttribute("task",new TaskForm());
        return "creatingTask";
    }
}
