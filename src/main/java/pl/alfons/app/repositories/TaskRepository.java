package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Project;
import pl.alfons.app.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository <Task, UUID> {

    List<Task> findAllByProjectOrderByModifyDateDesc(Project project);
}
