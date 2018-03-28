package pl.alfons.app.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.alfons.app.entities.Project;
import pl.alfons.app.repositories.ProjectRepository;

import java.util.List;

@Component
public class ApplicationRunnerBean implements ApplicationRunner {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void run(ApplicationArguments arg0) {

        projectRepository.save(new Project("Project name"));
        projectRepository.save(new Project("Project name 2"));


        Project newObject1 = new Project(123, "nazwa srazwa");

        System.out.println("object: " + newObject1);

        projectRepository.save(newObject1);

        System.out.println("end");

        List<Project> list = projectRepository.findAll();
        for(Project p : list) {
            System.out.println(p.getId());
        }


    }
}
