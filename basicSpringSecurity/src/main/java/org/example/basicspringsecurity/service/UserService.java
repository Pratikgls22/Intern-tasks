package org.example.basicspringsecurity.service;

import org.example.basicspringsecurity.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> search();

    User searchId(String name);
}
