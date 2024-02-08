package org.example.jwtspringsecurity.service;

import org.example.jwtspringsecurity.model.CustomUserDetail;
import org.example.jwtspringsecurity.model.User;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDao.findByName(username);

        return optionalUser.map(CustomUserDetail::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found!!"+username));
    }
}
