package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {}