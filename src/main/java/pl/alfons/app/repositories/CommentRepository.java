package pl.alfons.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alfons.app.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
