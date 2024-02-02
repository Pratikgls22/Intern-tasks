package org.example.basicspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsecurity.model.User;
import org.example.basicspringsecurity.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secureUser")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/search")
    public List<User> search(){
        return userService.search();
    }

    @GetMapping("/search/{name}")
    public User searchId(@PathVariable String name){
        return userService.searchId(name);
    }
}
