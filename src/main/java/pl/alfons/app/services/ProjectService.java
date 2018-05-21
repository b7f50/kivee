package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Project;
import pl.alfons.app.forms.ProjectForm;
import pl.alfons.app.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getProjectById(String id) {
        Long longId = Long.valueOf(id);
        return projectRepository.findOne(longId);
    }

    public Project saveProject(ProjectForm projectForm) {
        return projectRepository.save(new Project(projectForm.getName()));
    }
}
