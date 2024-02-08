package org.example.jwtspringsecurity.service;

import org.example.jwtspringsecurity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    List<User> search();

    Optional<User> searchId(Long id);

    User update(Long id, User user);

    User delete(Long id);

}
