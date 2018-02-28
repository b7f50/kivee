package pl.alfons.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.alfons.app.entities.Project;
import pl.alfons.app.repositories.ProjectRepository;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		projectRepository.save(new Project("Project name"));
        projectRepository.save(new Project("Project name 2"));
        System.out.println(projectRepository.count());
    }
}
