package org.example.jwtspringsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.model.CustomUserDetail;
import org.example.jwtspringsecurity.model.Users;
import org.example.jwtspringsecurity.repositry.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userDao.findByName(username);

        optionalUser.ifPresent(user -> System.out.println("\nUsername ::: " + user));

        return optionalUser.map(CustomUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!!" + username));
    }
}
