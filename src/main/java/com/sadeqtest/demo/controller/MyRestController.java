package com.sadeqtest.demo.controller;

import com.sadeqtest.demo.controller.dto.CommentDto;
import com.sadeqtest.demo.model2.Post;
import com.sadeqtest.demo.repository.EntityManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MyRestController {
    @Autowired
    private EntityManagerDao entityManagerDao;
    @PutMapping("/comment/text")
    public Integer updateCommentsText(@RequestBody CommentDto commentDto){
        AtomicInteger updatedRecords= new AtomicInteger();
        entityManagerDao.doInJpa((entityManager -> {
            Post post = entityManager.find(Post.class, commentDto.getPostUUID());
            post.getComments().stream().forEach(comment -> {updatedRecords.getAndIncrement(); comment.setText(commentDto.getText());});
        }));
        return updatedRecords.get();
    }
}
