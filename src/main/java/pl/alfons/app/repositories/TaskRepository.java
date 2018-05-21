package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Project;
import pl.alfons.app.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    List<Task> findAllByProjectOrderByModifyDateDesc(Project project);
}
