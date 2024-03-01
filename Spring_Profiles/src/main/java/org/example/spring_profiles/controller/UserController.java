package org.example.spring_profiles.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_profiles.dto.ApiResponse;
import org.example.spring_profiles.dto.UserDto;
import org.example.spring_profiles.dto.UserResponseDto;
import org.example.spring_profiles.entity.User;
import org.example.spring_profiles.service.UserService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
@Slf4j
public class UserController {

    private final UserService userService;
    private final Environment environment;

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse> insert(@RequestBody UserDto userDto){
        this.userService.insert(userDto);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "User Added !!", userDto),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> search(){
        var response = this.userService.search();
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Users list is Here !!",response),HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ApiResponse> searchId(@PathVariable Long id){
        var response = this.userService.searchId(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Your User with id :: "+id ,response),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody UserDto userDto, @PathVariable Long id){
        this.userService.update(id,userDto);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "User Updated !!", new HashMap<>()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        this.userService.delete(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"User Deleted !!",new HashMap<>()),HttpStatus.OK);
    }

    @GetMapping("/get")
    public void get(){
        String [] env = environment.getActiveProfiles();
        for (String env1 : env){
            log.info("=======================================================================>");
            log.info("\n your Current Profile is :" + env1);
        }
    }
}
