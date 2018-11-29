package com.b7f50.kivee.controllers;

import com.b7f50.kivee.forms.CommentForm;
import com.b7f50.kivee.forms.TaskForm;
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
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/project/{project_id}/task")
    public String create(
            Model model,
            @PathVariable(value = "project_id") String projectId) {
        model.addAttribute("taskForm", new TaskForm());
        return "task/create";
    }

    @PostMapping("/project/{project_id}/task")
    public RedirectView create(
            @ModelAttribute TaskForm taskForm,
            @PathVariable(value = "project_id") String projectId) {
        taskService.saveTaskInProject(taskForm, projectId);
        return new RedirectView("/project/" + projectId);
    }

    @GetMapping(value = "project/{project_id}/task/{task_id}")
    public String view(
            Model model,
            @PathVariable(value = "project_id") String projectId,
            @PathVariable(value = "task_id") String taskId) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        model.addAttribute("commentForm", new CommentForm());
        return "task/view";
    }
}
