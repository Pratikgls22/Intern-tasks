package org.example.testcasesspringboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.testcasesspringboot.entity.User;
import org.example.testcasesspringboot.repositry.UserDao;
import org.example.testcasesspringboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> search() {
        return userDao.findAll();
    }

    @Override
    public User searchId(long id) {
      return userDao.findById(id).orElseThrow(()->new RuntimeException("Not Found !!"));
    }

    @Override
    public void delete(Long id) {
        User user = userDao.findById(id).orElseThrow(()->new RuntimeException("Not Deleted !!"));
        userDao.delete(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> optionalUser = Optional.ofNullable(userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Does not Exist!!")));

        optionalUser.get().setName(user.getName());
        optionalUser.get().setCity(user.getCity());
        optionalUser.get().setPhone(user.getPhone());

        return userDao.save(optionalUser.get());
    }
}
