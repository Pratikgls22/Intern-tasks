package org.example.jwtspringsecurity.service;

import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(UserDto userDto);

    List<User> search();

    Optional<User> searchId(Long id);

    User update(Long id, UserDto userDto);

    User delete(Long id);

}
