package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

//    public Long saveTask (TaskForm taskForm){
//
//    }
}
