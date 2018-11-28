package com.b7f50.kivee.services;

import com.b7f50.kivee.entities.Project;
import com.b7f50.kivee.forms.ProjectForm;
import com.b7f50.kivee.repositories.ProjectRepository;
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
