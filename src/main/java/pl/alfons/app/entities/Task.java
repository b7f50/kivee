package pl.alfons.app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "task")
    private Set<Comment> comments = new HashSet<>();

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
