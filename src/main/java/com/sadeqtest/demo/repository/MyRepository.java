package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.model.Lname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<Lname,Integer>, JpaSpecificationExecutor<Lname> {
    @Override
    List<Lname> findAll();

    @Override
    <S extends Lname> S save(S s);
//    @Query(value = "SELECT user FROM Lname AS user WHERE user.submitTime <= :timeStamp ORDER BY user.submitTime desc ")
//    List<Lname> orderedUsers(@Param(value="timeStamp")LocalDateTime localDateTime, Pageable pageable);

    @Override
    Page<Lname> findAll(Specification<Lname> specification, Pageable pageable);
}
