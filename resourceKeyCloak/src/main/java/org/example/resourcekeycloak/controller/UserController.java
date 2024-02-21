package org.example.resourcekeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/resource")
    public String home() {
        return "U are on Resource Server!!";
    }
}
