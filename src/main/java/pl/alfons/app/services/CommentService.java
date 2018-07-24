package pl.alfons.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.alfons.app.entities.Comment;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.repositories.CommentRepository;
import pl.alfons.app.repositories.TaskRepository;

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
        Task existingTask = taskRepository.findOne(uuid);
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
