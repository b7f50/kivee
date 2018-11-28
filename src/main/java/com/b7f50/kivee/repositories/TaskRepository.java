package com.b7f50.kivee.repositories;

import com.b7f50.kivee.entities.Project;
import com.b7f50.kivee.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findAllByProjectOrderByModifyDateDesc(Project project);
}
