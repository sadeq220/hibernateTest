package com.sadeqtest.demo.model2;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "comment")
@Table(name = "COMMENT")
public class Comment {

    public Comment() {
        //empty constructor to comply with POJO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;

    @Column(name = "TEXT",columnDefinition = "VARCHAR(150)")
    @Length(max = 150)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    private LocalDateTime commentCreationTime;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getCommentCreationTime() {
        return commentCreationTime;
    }
    @PrePersist
    private void setCommentCreationTime() {
        this.commentCreationTime = LocalDateTime.now();
    }

}
