package com.b7f50.kivee.controllers;

import com.b7f50.kivee.forms.CommentForm;
import com.b7f50.kivee.services.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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
