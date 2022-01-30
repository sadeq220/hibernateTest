package com.sadeqtest.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "address")
public class Address {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "user_id")
    private Lname lname;

    @Enumerated(value = EnumType.STRING)
    private City city;

    private String location;

    public Address() {
    }
    public Address(City city,String location){
        this.city=city;
        this.location=location;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @JsonIgnore
    public Lname getLname() {
        return lname;
    }

    public void setLname(Lname lname) {
        this.lname = lname;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
