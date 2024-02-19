package org.example.auth2server.service;

import lombok.RequiredArgsConstructor;
import org.example.auth2server.model.CustomUserDetails;
import org.example.auth2server.model.Users;
import org.example.auth2server.repositry.UserRepositry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepositry userRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepositry.findByName(username);
        optionalUsers
                .orElseThrow(()->new UsernameNotFoundException("Username Not Found!!"));
        return optionalUsers
                .map(CustomUserDetails::new)
                .get();
    }
}
