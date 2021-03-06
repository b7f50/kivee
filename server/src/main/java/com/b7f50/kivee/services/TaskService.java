package com.b7f50.kivee.services;

import com.b7f50.kivee.entities.Project;
import com.b7f50.kivee.entities.Task;
import com.b7f50.kivee.forms.TaskForm;
import com.b7f50.kivee.repositories.ProjectRepository;
import com.b7f50.kivee.repositories.TaskRepository;
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
        Project existingProject = projectRepository.getOne(uuid);
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
        return taskRepository.getOne(uuid);
    }

    @Transactional(readOnly = true)
    public List<Task> getOrderedTasksByProject(Project project) {
        return taskRepository.findAllByProjectOrderByModifyDateDesc(project);
    }
}
