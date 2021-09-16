package com.sadeqtest.demo.model;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SQLInsert;

import javax.annotation.Priority;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "lName")
public class Lname {
    @Id
    private Integer id;
    private String lname;
    @Column(name = "GP")
    private Integer group;

    @OneToOne(mappedBy = "lname")
    @PrimaryKeyJoinColumn
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Lname() {
    }

    public Lname(Integer id, String lname, Integer group) {
        this.id=id;
        this.lname=lname;
        this.group=group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
    }
}
