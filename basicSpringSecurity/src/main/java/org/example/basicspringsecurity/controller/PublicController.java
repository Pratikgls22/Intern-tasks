package org.example.basicspringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/home")
    public String home(){
        return "This is Home Page !!";
    }


//    @PreAuthorize("hasRole('ADMIN')")      only use when you want to call by admin spcifice api
    @GetMapping("/login")
    public String login(){
        return "This is Login Page !!";
    }
}
