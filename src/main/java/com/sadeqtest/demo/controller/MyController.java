package com.sadeqtest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/home")
    public String getHome(@RequestParam(defaultValue = "sadeq") String name){
        return "hello "+name;
    }
    @GetMapping("/exception")
    public void getException(@RequestParam(defaultValue = "unknown") String name){
        throw new RuntimeException("sadeq launched this");
    }
}
