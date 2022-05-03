package com.sadeqtest.demo.model2;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(generator = "system-gen")
    @GenericGenerator(name="system-gen",strategy = "uuid2")
    private String postId;

    @Column(name = "LIKES")
    private Long likes;

    @OneToMany(mappedBy = "post",orphanRemoval = true,cascade = CascadeType.ALL)
   // @OrderBy("commentCreationTime DESC")
    List<Comment> comments=new ArrayList<>();
    public Post(){
        // default constructor to comply with POJO
    }
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
