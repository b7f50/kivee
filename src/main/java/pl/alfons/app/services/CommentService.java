package pl.alfons.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Comment;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.repositories.CommentRepository;
import pl.alfons.app.repositories.TaskRepository;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    public boolean addNewCommentToTask(CommentForm commentForm, String taskId) {
        Long longId = Long.valueOf(taskId);
        Task existingTask = taskRepository.findOne(longId);
        if (existingTask == null) {
            return false;
        }

        Comment comment = new Comment(commentForm.getDescription());
        existingTask.getComments().add(comment);
        comment.setTask(existingTask);
        comment = commentRepository.save(comment);
        existingTask.setModifyDate(comment.getCreateDate());
        taskRepository.save(existingTask);
        return true;
    }
}
