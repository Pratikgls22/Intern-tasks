package org.example.swaggeruispringboot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.swaggeruispringboot.dto.UserDto;
import org.example.swaggeruispringboot.exception.UserNotFoundException;
import org.example.swaggeruispringboot.model.User;
import org.example.swaggeruispringboot.repositry.UserDao;
import org.example.swaggeruispringboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Override
    public User create(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return this.userDao.save(user);
    }

    @Override
    public List<User> search() {
        return this.userDao.findAll();
    }

    @SneakyThrows    //use for exception handling
    @Override
    public Optional<User> serachId(Long id) {
       if(userDao.findById(id).isEmpty()){
           throw new UserNotFoundException("Request User Doesn't Exist");
       }
       return userDao.findById(id);
    }

    @Override
    public User update(Long id, UserDto userDto) {
        User user = userDao.findById(id).orElseThrow(() -> new UserNotFoundException("ID is Not Found"));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return this.userDao.save(user);
    }

    @Override
    public User delete(Long id) {
        Optional<User> user = userDao.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("Your User Id Doesn't Exist !!");
        }
        else {
                User user1 = user.get();
                userDao.delete(user1);
                return user1;
        }
    }
}
