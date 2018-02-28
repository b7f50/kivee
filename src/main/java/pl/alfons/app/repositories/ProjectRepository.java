package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}

//Long
//public interface BookRepository extends CrudRepository<Book, Long> {
//    List<Book> findByTitle(String title);
//    Optional<Book> findOne(long id);
//}