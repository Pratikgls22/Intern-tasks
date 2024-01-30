package org.example.testcasesspringboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.testcasesspringboot.model.User;
import org.example.testcasesspringboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/search")
    public List<User> search() {
        return userService.search();
    }

    @GetMapping("/search/{id}")
    public User searchId(@PathVariable long id) {
        return userService.searchId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }
}
