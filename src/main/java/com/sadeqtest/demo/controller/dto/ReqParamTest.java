package com.sadeqtest.demo.controller.dto;

public class ReqParamTest {
    String name;
    Integer age;
    String mood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return this.name+" : "+this.age+" : "+this.mood;
    }
}
