package org.example.jwtspringsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.dto.UserResponseDto;
import org.example.jwtspringsecurity.exception.CustomException;
import org.example.jwtspringsecurity.model.Users;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.example.jwtspringsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private static final String ACTION_1 = "User Not Found !!";

    public UserResponseDto mapToUserResponseDto(Users user){
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto create(UserDto userDto) {
        try {
            Users user = this.modelMapper.map(userDto, Users.class);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userDao.save(user);
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
        return null;
    }

    @Override
    public List<UserResponseDto> search() {
        try{
            return userDao.findAll().stream()
                    .map(this::mapToUserResponseDto)
                    .collect(Collectors.toList());
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
    }

    @Override
    public UserResponseDto searchId(Long id) {
         try{
             var user = this.userDao.findById(id);
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
    public void update(Long id, UserDto userDto)  {
      try {
          var byId = this.userDao.findById(id);
          if (byId.isEmpty()){
              throw new CustomException(ACTION_1,HttpStatus.NOT_FOUND);
          }
          Users user = byId.get();
          user.setName(userDto.getName());
          user.setEmail(userDto.getEmail());
          user.setRoles(userDto.getRoles());
          user.setPassword(userDto.getPassword());
          userDao.save(user);
      }
      catch (CustomException e){
          throw new CustomException(e.getMessage(),e.getHttpStatus());
      }
    }

    @Override
    public void delete(Long id){

       try {
           var byId = userDao.findById(id);
           if (byId.isEmpty()){
               throw new CustomException(ACTION_1,HttpStatus.NOT_FOUND);
           }
           userDao.deleteById(id);
       }
       catch (CustomException e){
           throw new CustomException(e.getMessage(),e.getHttpStatus());
       }

    }

}
