package org.example.springbootvalidator.service;

import org.example.springbootvalidator.model.User;
import org.example.springbootvalidator.requestDTO.UserRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User add(UserRequestDTO userRequestDTO);
    List<User> search();
    Optional<User> getUserID(long id);
    String delete(long id);
    User update(long id, UserRequestDTO userRequestDTO);
}
