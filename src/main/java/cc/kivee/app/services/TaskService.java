package cc.kivee.app.services;

import cc.kivee.app.entities.Project;
import cc.kivee.app.entities.Task;
import cc.kivee.app.forms.TaskForm;
import cc.kivee.app.repositories.ProjectRepository;
import cc.kivee.app.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Task saveTaskInProject(TaskForm taskForm, String projectId) {
        UUID uuid = UUID.fromString(projectId);
        Project existingProject = projectRepository.findOne(uuid);
        if (existingProject == null) {
            return null;
        }
        Task newTask = new Task(taskForm);
        existingProject.getTasks().add(newTask);
        newTask.setProject(existingProject);
        return taskRepository.save(newTask);
    }

    @Transactional(readOnly = true)
    public Task getTaskById(String taskId) {
        UUID uuid = UUID.fromString(taskId);
        return taskRepository.findOne(uuid);
    }

    @Transactional(readOnly = true)
    public List<Task> getOrderedTasksByProject(Project project) {
        return taskRepository.findAllByProjectOrderByModifyDateDesc(project);
    }
}
