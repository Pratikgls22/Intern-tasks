package org.example.jwtspringsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.model.User;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.example.jwtspringsecurity.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public List<User> search() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> searchId(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User update(Long id, User user) {
        User user1 = userDao.findById(id).orElseThrow(() -> new RuntimeException("id is not valid !!"));
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        return userDao.save(user1);
    }

    @Override
    public User delete(Long id) {
        userDao.deleteById(id);
        return null;
    }

}
