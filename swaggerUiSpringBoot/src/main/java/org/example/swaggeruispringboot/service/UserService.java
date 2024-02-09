package org.example.swaggeruispringboot.service;

import org.example.swaggeruispringboot.dto.UserDto;
import org.example.swaggeruispringboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(UserDto userDto);

    List<User> search();

    Optional<User> serachId(Long id);

    User update(Long id, UserDto userDto);

    User delete(Long id);
}
