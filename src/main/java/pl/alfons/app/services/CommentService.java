package pl.alfons.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Comment;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.CommentForm;
import pl.alfons.app.repositories.CommentRepository;
import pl.alfons.app.repositories.TaskRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        if(existingTask == null) {
            return false;
        }

        Comment comment = new Comment(commentForm.getDescription());
        existingTask.getComments().add(comment);
        comment.setTask(existingTask);
        moveTaskToFirst(existingTask);
        existingTask.setCommentsQuantity(existingTask.getCommentsQuantity()+1);
        Date date = new Date();
        comment.setDate(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        log.debug("date saved: "+ dateFormat.format(date));
        commentRepository.save(comment);
        return true;
    }

    public void moveTaskToFirst(Task taskToMove){
        List<Task> listOfTasks = taskToMove.getProject().getTasks();
        listOfTasks.remove(taskToMove);
        listOfTasks.add(taskToMove);
        taskToMove.getProject().setTasks(listOfTasks);
        // prawdopodobnie tutaj dzieje się to tylko lokalnie
    }
}
