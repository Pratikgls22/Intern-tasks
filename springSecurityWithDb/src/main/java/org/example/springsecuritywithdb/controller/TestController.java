package org.example.springsecuritywithdb.controller;

import org.example.springsecuritywithdb.model.Student;
import org.example.springsecuritywithdb.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class TestController {

    @GetMapping("/signIn")
    public String signIn(){
       return "signIn.html";
    }
}
