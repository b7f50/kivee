package com.b7f50.kivee.entities;

import com.b7f50.kivee.forms.CommentForm;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public Comment(CommentForm commentForm) {
        this.description = commentForm.getDescription();
    }
}
