package org.example.basicspringsecurity.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsecurity.model.User;
import org.example.basicspringsecurity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    List<User> userList = new ArrayList<>();

    public UserServiceImpl(){
        userList.add(new User("pratik","pra@123"));
        userList.add(new User("preyal","pre@123"));
    }


    @Override
    public User create(User user) {
        System.out.println(userList);
         this.userList.add(user);
         return user;
    }

    @Override
    public List<User> search() {
        return this.userList;
    }

    @Override
    public User searchId(String name) {
        return this.userList.stream().filter(user -> user.getName().equals(name)).findAny().get();
    }
}
