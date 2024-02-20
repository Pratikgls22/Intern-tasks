package org.example.jwtspringsecurity.service;

import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.exception.UserNotFoundException;
import org.example.jwtspringsecurity.model.User;

import java.util.List;

public interface UserService {
    User create(UserDto userDto);

    List<User> search();

    User searchId(Long id) throws UserNotFoundException;

    User update(Long id, UserDto userDto) throws UserNotFoundException;

    User delete(Long id) throws UserNotFoundException;

}
