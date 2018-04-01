package pl.alfons.app.entities;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    public Task(String name) {
        this.name = name;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
