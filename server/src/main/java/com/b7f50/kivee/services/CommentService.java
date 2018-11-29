package com.b7f50.kivee.services;

import com.b7f50.kivee.entities.Comment;
import com.b7f50.kivee.entities.Task;
import com.b7f50.kivee.forms.CommentForm;
import com.b7f50.kivee.repositories.CommentRepository;
import com.b7f50.kivee.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Comment addNewCommentToTask(CommentForm commentForm, String taskId) {
        UUID uuid = UUID.fromString(taskId);
        Task existingTask = taskRepository.getOne(uuid);
        if (existingTask == null) {
            return null;
        }

        Comment comment = new Comment(commentForm);
        existingTask.getComments().add(comment);
        comment.setTask(existingTask);
        comment = commentRepository.save(comment);
        existingTask.setModifyDate(comment.getCreateDate());
        taskRepository.save(existingTask);
        return comment;
    }
}
