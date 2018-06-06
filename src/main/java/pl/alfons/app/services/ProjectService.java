package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.alfons.app.entities.Project;
import pl.alfons.app.forms.ProjectForm;
import pl.alfons.app.repositories.ProjectRepository;

import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Project getProjectById(String projectId) {
        UUID uuid = UUID.fromString(projectId);
        return projectRepository.findOne(uuid);
    }

    @Transactional
    public Project saveProject(ProjectForm projectForm) {
        return projectRepository.save(new Project(projectForm));
    }
}
