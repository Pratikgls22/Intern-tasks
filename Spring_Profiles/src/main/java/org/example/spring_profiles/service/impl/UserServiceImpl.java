package org.example.spring_profiles.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring_profiles.dto.UserDto;
import org.example.spring_profiles.dto.UserResponseDto;
import org.example.spring_profiles.entity.User;
import org.example.spring_profiles.exception.CustomException;
import org.example.spring_profiles.repositry.UserRepositry;
import org.example.spring_profiles.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositry userRepositry;
    private final ModelMapper modelMapper;
    private static final String ACTION_1 = "User Not Found !!";

    public UserResponseDto mapToUserResponseDto(User user){
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto insert(UserDto userDto) {
        try {
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setAge(userDto.getAge());
            userRepositry.save(user);
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
        return null;
    }

    @Override
    public List<UserResponseDto> search() {
       try {
           return userRepositry.findAll().stream()
                   .map(this::mapToUserResponseDto)
                   .toList();
       }
       catch (CustomException e){
           throw new CustomException(e.getMessage(),e.getHttpStatus());
       }
    }

    @Override
    public UserResponseDto searchId(Long id) {
        try {
            var user = this.userRepositry.findById(id);
            if (user.isEmpty()){
                throw new CustomException(ACTION_1, HttpStatus.NOT_FOUND);
            }
            return this.modelMapper.map(user.get(), UserResponseDto.class);
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
    }

    @Override
    public void update(Long id, UserDto userDto) {
        try {
            var byId = this.userRepositry.findById(id);
            if (byId.isEmpty()){
                throw new CustomException(ACTION_1,HttpStatus.NOT_FOUND);
            }
            User user = byId.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setAge(userDto.getAge());
            userRepositry.save(user);
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            var byId = userRepositry.findById(id);
            if (byId.isEmpty()){
                throw new CustomException(ACTION_1,HttpStatus.NOT_FOUND);
            }
            userRepositry.deleteById(id);
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
    }
}
