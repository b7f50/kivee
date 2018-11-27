package cc.kivee.app.repositories;

import cc.kivee.app.entities.Project;
import cc.kivee.app.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findAllByProjectOrderByModifyDateDesc(Project project);
}
