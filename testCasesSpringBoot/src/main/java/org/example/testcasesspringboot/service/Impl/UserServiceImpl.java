package org.example.testcasesspringboot.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.testcasesspringboot.model.User;
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
        Optional<User> optionalUser = userDao.findById(id);
        optionalUser.get().setName(user.getName());
        optionalUser.get().setCity(user.getCity());
        optionalUser.get().setPhone(user.getPhone());
        return userDao.save(optionalUser.get());

//        User user1 = userDao.findById(id).orElseThrow(()-> new RuntimeException("Data Not Updated !!"));
//        user1.setName(user.getName());
//        user1.setCity(user.getCity());
//        user1.setPhone(user.getPhone());
//        return userDao.save(user1);
    }
}
