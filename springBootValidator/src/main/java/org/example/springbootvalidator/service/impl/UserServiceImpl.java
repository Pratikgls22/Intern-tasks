package org.example.springbootvalidator.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springbootvalidator.model.User;
import org.example.springbootvalidator.repositry.UserDao;
import org.example.springbootvalidator.requestDTO.UserRequestDTO;
import org.example.springbootvalidator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public User add(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        return userDao.save(user);
    }

    @Override
    public List<User> search() {
       return this.userDao.findAll();
    }

    @Override
    public Optional<User> getUserID(long id) {
        return this.userDao.findById(id);
    }

    @Override
    public String delete(long id) {
        User user = new User();
        user.setId(id);
        this.userDao.delete(user);
        return "user deleted!!";
    }

    @Override
    public User update(long id, UserRequestDTO userRequestDTO) {
        Optional<User> user = userDao.findById(id);
        if(user.isPresent()){
            user.get().setName(userRequestDTO.getName());
            user.get().setEmail(userRequestDTO.getEmail());
            user.get().setPassword(userRequestDTO.getPassword());
            return this.userDao.save(user.get());
        }
        else {
                return null;
        }
    }


}

