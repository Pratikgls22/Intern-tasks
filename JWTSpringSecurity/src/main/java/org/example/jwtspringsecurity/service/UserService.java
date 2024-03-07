package org.example.jwtspringsecurity.service;

import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service

public interface UserService {


    UserResponseDto create(UserDto userDto);

    Object search();

    Object searchId(Long id);

    void update(Long id, UserDto userDto);

    void delete(Long id);
}
