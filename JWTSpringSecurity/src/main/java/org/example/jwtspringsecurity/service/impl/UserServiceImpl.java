package org.example.jwtspringsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.model.User;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.example.jwtspringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public User create(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
//        User user = new User();
//        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setEmail(userDto.getEmail());
//        user.setRoles(userDto.getRoles());
//      user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public User update(Long id, UserDto userDto) {
        User user1 = userDao.findById(id).orElseThrow(() -> new RuntimeException("id is not valid !!"));
        user1.setName(userDto.getName());
        user1.setPassword(userDto.getPassword());
        user1.setEmail(userDto.getEmail());
        user1.setRoles(userDto.getRoles());
        return userDao.save(user1);
    }

    @Override
    public User delete(Long id) {
        userDao.deleteById(id);
        return null;
    }

}
