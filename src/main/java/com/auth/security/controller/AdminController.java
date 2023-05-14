package com.auth.security.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping("/admin/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello"+name;
    }
}
