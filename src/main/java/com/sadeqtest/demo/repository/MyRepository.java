package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.model.Lname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepository extends JpaRepository<Lname,Integer>, JpaSpecificationExecutor<Lname> {
    @Override
    List<Lname> findAll();

    @Override
    <S extends Lname> S save(S s);

    @Override
    Page<Lname> findAll(Specification<Lname> specification, Pageable pageable);
}
