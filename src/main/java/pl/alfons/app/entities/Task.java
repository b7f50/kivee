package pl.alfons.app.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private List<Comment> comments = new LinkedList<>();

    private int commentsQuantity = 0;

    private Date recentCommentDate;

    private Date date;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
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

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public void setCommentsQuantity(int commentsQuantity) {
        this.commentsQuantity = commentsQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getRecentCommentDate() {
        return recentCommentDate;
    }

    public void setRecentCommentDate(Date recentCommentDate) {
        this.recentCommentDate = recentCommentDate;
    }
}
