package org.example.swaggeruispringboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.swaggeruispringboot.model.User;
import org.example.swaggeruispringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> create(@RequestBody User user) {
        user = userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> search() {
        List<User> search = userService.search();
        return new ResponseEntity<>(search, HttpStatus.FOUND);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<User> searchId(@PathVariable Long id) {
        return userService.serachId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user){
        User update = userService.update(id, user);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
}
