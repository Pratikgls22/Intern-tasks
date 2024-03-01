package org.example.jwtspringsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.exception.UserNotFoundException;
import org.example.jwtspringsecurity.model.User;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.example.jwtspringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public User create(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userDao.save(user);
    }

    @Override
    public List<User> search() {
        return userDao.findAll();
    }

    @Override
    public User searchId(Long id) throws UserNotFoundException {
        return userDao.findById(id).
                orElseThrow(() -> new UserNotFoundException("Id not found !!"));
    }

    @Override
    public User update(Long id, UserDto userDto) throws UserNotFoundException {
        User user1 = userDao.findById(id).orElseThrow(() -> new UserNotFoundException("Id not found !!"));
        user1.setName(userDto.getName());
        user1.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user1.setEmail(userDto.getEmail());
        user1.setRoles(userDto.getRoles());
        return userDao.save(user1);
    }

    @Override
    public User delete(Long id) throws UserNotFoundException {

       return this.userDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Id not found"));

    }

}
