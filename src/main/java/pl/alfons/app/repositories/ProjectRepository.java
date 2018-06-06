package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Project;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {}