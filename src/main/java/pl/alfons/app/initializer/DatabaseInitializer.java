package pl.alfons.app.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.alfons.app.entities.Project;
import pl.alfons.app.entities.Task;
import pl.alfons.app.repositories.ProjectRepository;
import pl.alfons.app.services.ProjectService;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    ProjectService projectService;

    @Override
    public void run(ApplicationArguments arg0) {

        Project project1 = new Project("Project name 1");
        System.out.println(project1.getId());
        Task task1 = new Task ("task name 1");
        Task task2 = new Task ("task name 2");

        task1.setProject(project1);
        task2.setProject(project1);

        project1.getTasks().add(task1);
        project1.getTasks().add(task2);

        projectRepository.save(project1);
    }
}
