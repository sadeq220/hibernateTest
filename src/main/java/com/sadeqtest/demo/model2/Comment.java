package com.sadeqtest.demo.model2;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity(name = "comment")
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;
    @Column(name = "TEXT",columnDefinition = "VARCHAR(150)")
    @Length(max = 150)
    private String text;
    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;
}
