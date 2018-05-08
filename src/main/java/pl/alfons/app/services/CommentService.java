package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Comment;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.repositories.CommentRepository;
import pl.alfons.app.repositories.TaskRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    public void saveComment(CommentForm commentForm, String id) {
        Long longId = Long.valueOf(id);
        Comment comment = new Comment(commentForm.getValue());
        Task newTask = taskRepository.findOne(longId);
        newTask.getComments().add(comment);
        comment.setTask(newTask);
        commentRepository.save(comment);
    }

}
