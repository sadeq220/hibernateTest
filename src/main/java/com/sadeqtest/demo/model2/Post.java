package com.sadeqtest.demo.model2;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(generator = "system-gen")
    @GenericGenerator(name="system-gen",strategy = "uuid2")
    private String postId;
    @Column(name = "LIKES")
    private Long likes;

}
