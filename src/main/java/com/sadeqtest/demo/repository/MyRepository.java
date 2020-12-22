package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.model.Lname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<Lname,Integer> {
    @Override
    List<Lname> findAll();

}
