package cc.kivee.app.services;

import cc.kivee.app.entities.Project;
import cc.kivee.app.forms.ProjectForm;
import cc.kivee.app.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
