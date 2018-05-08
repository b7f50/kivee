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
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.forms.TaskForm;
import pl.alfons.app.services.CommentService;
import pl.alfons.app.services.TaskService;

@Slf4j
@Controller
public class TaskViewController {

    @Autowired
    TaskService taskService;

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/wp/{id}/tt")
    public String creatingTask(Model model, @PathVariable String id) {
        model.addAttribute("task", new TaskForm());
        return "creatingTask";
    }

    @PostMapping ("/wp/{id}/tt")
    public RedirectView taskSubmit(@ModelAttribute TaskForm task, @PathVariable String id) {
        log.debug("lombok debug: checkpoint 1.  id: " +id);
        taskService.saveTask(task, id);
        return new RedirectView("/wp/"+id);
    }

    @GetMapping (value = "wp/{id}/wt/{tid}")
    public String getTask (Model model, @PathVariable String tid, @PathVariable String id){
        model.addAttribute("task", taskService.getTaskById(tid));
        model.addAttribute("comment", new CommentForm());
        log.debug(taskService.getTaskById(tid).getName());
        return "task";
    }

    @PostMapping("/wp/{id}/wt/{tid}")
    public RedirectView commentSubmit(@ModelAttribute CommentForm comment, @PathVariable String id, @PathVariable String tid) {
      commentService.saveComment(comment,tid);
      return new RedirectView("/wp/{id}/wt/{tid}");
    }
}
