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
        Task task1 = new Task ("task name 1","opis długopis");
        Task task2 = new Task ("task name 2","opis drugi");

        task1.setProject(project1);
        task2.setProject(project1);

        project1.getTasks().add(task1);
        project1.getTasks().add(task2);

//        Comment comment = new Comment("Taki sobie komentarz");
//        comment.setTask(task1);
//        task1.getComments().add(comment);

        projectRepository.save(project1);

//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        System.out.println(dateFormat.format(date));
    }
}
