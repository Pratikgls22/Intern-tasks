package org.example.swaggeruispringboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.swaggeruispringboot.dto.UserDto;
import org.example.swaggeruispringboot.model.User;
import org.example.swaggeruispringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public User create(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> search() {
        List<User> search = userService.search();
        return new ResponseEntity<>(search, HttpStatus.FOUND);
    }

    @GetMapping("/search/{id}")
    public Optional<User> searchId(@PathVariable Long id) {
        return userService.serachId(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody UserDto userDto){
       return userService.update(id,userDto);
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
