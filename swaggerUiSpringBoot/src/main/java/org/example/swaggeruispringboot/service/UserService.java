package org.example.swaggeruispringboot.service;

import org.example.swaggeruispringboot.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> search();

    ResponseEntity<User> serachId(Long id);

    User update(Long id, User user);
}
