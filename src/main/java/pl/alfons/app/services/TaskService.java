package pl.alfons.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Project;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.TaskForm;
import pl.alfons.app.repositories.ProjectRepository;
import pl.alfons.app.repositories.TaskRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public void saveTask (TaskForm taskForm, String id){
    Long longId = Long.valueOf(id);
    Task newTask = new Task(taskForm.getName(), taskForm.getDescription());
    Project existingProject = projectRepository.findOne(longId);
    existingProject.getTasks().add(newTask);
    newTask.setProject(existingProject);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        log.debug("new task saved at: "+dateFormat.format(date));
    taskRepository.save(newTask);
    }

    public Task getTaskById (String id){
        Long longId = Long.valueOf(id);
        return taskRepository.findOne(longId);
    }
}
