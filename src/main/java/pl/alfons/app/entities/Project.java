package pl.alfons.app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();

    public Project() {}


    public Project(String name) {
        this.name = name;
    }

    public Project (Long id, String name){
        this.name = name;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<Task> getTasks() {
        return tasks;
    }
}
