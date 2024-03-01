package org.example.testcasesspringboot.service;

import org.example.testcasesspringboot.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> search();

    User searchId(long id);

    void delete(Long id);

    User update(Long id, User user);
}
