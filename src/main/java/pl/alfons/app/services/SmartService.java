package pl.alfons.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.alfons.app.entities.Project;
import pl.alfons.app.repositories.ProjectRepository;

import java.util.List;

@Service
public class SmartService {

    @Autowired
    ProjectRepository projectRepository;

    @Value("${app.lalala}")
    String lalala;

    public String getName() {
        return getLalala();
    }

    public String getLalala() {
        List<Project> projectList = projectRepository.findAll();
        if (projectList.size() > 0) {
            return projectList.get(0).getName();
        }
        return lalala;
    }
}
