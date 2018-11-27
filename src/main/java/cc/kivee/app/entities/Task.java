package cc.kivee.app.entities;

import cc.kivee.app.forms.TaskForm;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "task")
    private List<Comment> comments = new LinkedList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public Task(TaskForm taskForm) {
        this.name = taskForm.getName();
        this.description = taskForm.getDescription();
    }

    @Transient
    public int commentsQuantity() {
        return comments.size();
    }
}
