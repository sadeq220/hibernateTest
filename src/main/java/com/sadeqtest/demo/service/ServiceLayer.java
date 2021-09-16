package com.sadeqtest.demo.service;

import com.sadeqtest.demo.controller.dto.LnameDto;
import com.sadeqtest.demo.model.Lname;
import com.sadeqtest.demo.repository.MyRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

@Service
public class ServiceLayer {
    private MyRepository myRepository;

    @Autowired
    public ServiceLayer(MyRepository myRepository, EntityManager entityManager){
        Session unwrap = entityManager.unwrap(Session.class);

        this.myRepository=myRepository;
    }
    public Page<Lname> filterSearch(LnameDto dto,Integer pageNo,Integer pageSize,String sortField){

        Specification specification=((root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> array = new ArrayList<>();
            if(dto.getUserID() != null){
                Predicate id = criteriaBuilder.equal(root.get("id"), dto.getUserID());
                array.add(id);
            }
            if(dto.getCity() != null){
                Predicate city=criteriaBuilder.equal(root.get("address.city"),dto.getCity());
                array.add(city);
            }
            if(dto.getLastName() != null){
                Predicate lastName=criteriaBuilder.like(root.get("lname"),"%"+dto.getLastName()+"%");
                array.add(lastName);
            }
            return criteriaBuilder.and(array.toArray(new Predicate[array.size()]));
        } );
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortField));
        return myRepository.findAll(specification,pageable);
    }

}
