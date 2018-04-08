package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
