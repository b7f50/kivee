package pl.alfons.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.services.CommentService;

@Slf4j
@Controller
public class CommentController {


    @Autowired
    CommentService commentService;

    @PostMapping("/project/{project_id}/task/{task_id}/comment")
    public RedirectView create(
            @ModelAttribute CommentForm commentForm,
            @PathVariable(value = "project_id") String projectId,
            @PathVariable(value = "task_id") String taskId) {
        commentService.addNewCommentToTask(commentForm, taskId);
        return new RedirectView("/project/{project_id}/task/{task_id}");
    }
}
