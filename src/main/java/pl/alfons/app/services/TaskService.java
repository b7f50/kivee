package pl.alfons.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Project;
import pl.alfons.app.entities.Task;
import pl.alfons.app.forms.TaskForm;
import pl.alfons.app.repositories.ProjectRepository;
import pl.alfons.app.repositories.TaskRepository;

import java.util.List;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public Task saveTask(TaskForm taskForm, String projectId) {
        Long longId = Long.valueOf(projectId);
        Project existingProject = projectRepository.findOne(longId);
        if(existingProject == null) {
            return null;
        }

        Task newTask = new Task(taskForm.getName(), taskForm.getDescription());

        existingProject.getTasks().add(newTask);
        newTask.setProject(existingProject);
        return taskRepository.save(newTask);
    }

    public Task getTaskById(String id) {
        Long longId = Long.valueOf(id);
        return taskRepository.findOne(longId);
    }

    public List<Task> getTasksByProject(Project project) {
        return taskRepository.findAllByProjectOrderByModifyDateDesc(project);
    }
}
