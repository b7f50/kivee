package com.b7f50.kivee.entities;

import com.b7f50.kivee.forms.ProjectForm;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "project")
    private List<Task> tasks = new LinkedList<>();

    public Project(ProjectForm projectForm) {
        this.name = projectForm.getName();
    }
}
