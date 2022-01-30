package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.model.Address;
import com.sadeqtest.demo.model2.Comment;
import com.sadeqtest.demo.model2.Post;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Repository
public class EntityManagerDao {
    @PersistenceContext
    private EntityManager entityManager;
    private Session session;
    @PostConstruct
    private void initializeSession(){
        this.session=entityManager.unwrap(Session.class);
    }
    public Address findById(Integer addressId){
        Address address = session.find(Address.class, addressId);
        return address;
    }
    public Address getById(Integer addressId){
        Address address = session.get(Address.class,addressId);
        return address;
    }
    @Transactional
    public Serializable savePost(Long likes){
        Post post = new Post();
        post.setLikes(likes);
        return session.save(post);
    }

    /**
     * use default fetch plan to inject outer join into our query
     */
    public Comment findCommentById(Long commentId){
        Comment comment = session.find(Comment.class, commentId);
        return comment;
    }

    /**
     * override default fetch plan strategy by query fetch plan
     * this method will use 2 select statements
     * secondary queries are executed for FetchType.EAGER associations when executing a JPQL, Criteria API, or native SQL query that fetched entities
     */
    public Comment findCommentWithQueryById(Long commentId){
        Query<Comment> query = session.createQuery("SELECT c FROM comment c WHERE c.CommentId=?1", Comment.class);
        query.setParameter(1,commentId);
        return query.getSingleResult();
    }
}
