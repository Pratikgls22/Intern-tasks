package org.example.spring_profiles.service;

import org.example.spring_profiles.dto.UserDto;
import org.example.spring_profiles.dto.UserResponseDto;

public interface UserService {
    UserResponseDto insert(UserDto userDto);

    Object search();

    Object searchId(Long id);

    void update(Long id, UserDto userDto);

    void delete(Long id);
}
