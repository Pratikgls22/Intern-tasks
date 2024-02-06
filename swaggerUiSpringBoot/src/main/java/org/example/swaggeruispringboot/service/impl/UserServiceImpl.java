package org.example.swaggeruispringboot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.swaggeruispringboot.model.User;
import org.example.swaggeruispringboot.repositry.UserDao;
import org.example.swaggeruispringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Override
    public User create(User user) {
        return this.userDao.save(user);
    }

    @Override
    public List<User> search() {
        return this.userDao.findAll();
    }

    @SneakyThrows    //use for exception handling
    @Override
    public ResponseEntity<User> serachId(Long id) {
       userDao.findById(id)
                .orElseThrow(()-> new Exception("Id not Found"));
        return null;
    }

    @Override
    public User update(Long id, User user) {
        User byId = userDao.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        byId.setId(id);
        return userDao.save(byId);
    }
}
