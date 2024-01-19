package org.example.springbootvalidator.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springbootvalidator.model.User;
import org.example.springbootvalidator.requestDTO.UserRequestDTO;
import org.example.springbootvalidator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // ADD User
    @PostMapping("/add")
    public User addUser(@Valid  @RequestBody UserRequestDTO userRequestDTO){
        return this.userService.add(userRequestDTO);
    }

    // Search User
    @GetMapping("/search")
    public ResponseEntity<List<User>> search(){
        List<User> userList = this.userService.search();
        return ResponseEntity.of(Optional.of(userList));
    }

    //Search User By Id
    @GetMapping("/search/{id}")
    public Optional<User> searchId(@PathVariable long id){
        return  this.userService.getUserID(id);
    }

    //Delete User By Id
    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable long id){
        return this.userService.delete(id);
    }

    //Update User By Id
    @PutMapping("/update/{id}")
    public User update(@Valid @PathVariable long id, @RequestBody UserRequestDTO userRequestDTO){
        return this.userService.update(id,userRequestDTO);
    }


}
