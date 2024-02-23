package org.example.resourcekeycloak.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class UserController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String home() {
        return "U Admin!!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('user')")
    public String search() {
        return "this is Search page !!";
    }

}
