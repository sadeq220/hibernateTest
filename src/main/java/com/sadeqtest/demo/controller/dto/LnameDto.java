package com.sadeqtest.demo.controller.dto;

import com.sadeqtest.demo.model.City;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;


public class LnameDto {
    @NotNull(message = "6669.userId.null")
    @PositiveOrZero(message = "6670.userId.integer")
    private Integer userID;
    @Pattern(regexp = "[a-zA-Z+#]{1,5}",message = "6774.not.valid.name")
    private String lastName;
    private Integer groupID;
    private City city;
    private String location;

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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
