package org.example.jwtspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.dto.ApiResponse;
import org.example.jwtspringsecurity.dto.JwtResponse;
import org.example.jwtspringsecurity.dto.RefreshTokenRequest;
import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.requestdto.UserRequestDto;
import org.example.jwtspringsecurity.service.JwtService;
import org.example.jwtspringsecurity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
//    private final RefreshTokenService refreshTokenService;


    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody UserDto userDto) {
        this.userService.create(userDto);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "User Added !!", userDto), HttpStatus.OK);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<ApiResponse> search() {
        var response = this.userService.search();
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Users list is Here !!", response), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse> searchId(@PathVariable Long id) {
        var response = this.userService.searchId(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Your User with id :: " + id, response), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        this.userService.update(id, userDto);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "User Updated !!", new HashMap<>()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "User Deleted !!", new HashMap<>()), HttpStatus.OK);
    }

    // For Authentication
    @PostMapping("/auth")
    public JwtResponse authenticateAndGetToken(@RequestBody UserRequestDto userRequestDto) {
        System.out.println(":::: authenticateAndGetToken");
        Authentication authenticate = authenticationManager.
                authenticate(new
                        UsernamePasswordAuthenticationToken(userRequestDto.getUsername(),
                        userRequestDto.getPassword()));
        // { above authenticate var authenticated username and password !! }
        System.out.println("Authentication ::: " + authenticate.isAuthenticated());

        if (authenticate.isAuthenticated()) {
            JwtResponse jwtResponse = jwtService.generateToken(userRequestDto.getUsername());
            return jwtResponse;
            /*return JwtResponse.builder()
                    .accessToken(jwtService.generateToken(userRequestDto.getUsername()))
                    .token(refreshToken.getToken())
                    .build();*/
        } else {
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }

    @PostMapping("/refreshToken")
    public JwtResponse authenticateAndGetToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        JwtResponse jwtResponse = jwtService.createRefreshToken(refreshTokenRequest);
        return jwtResponse;
    }
}



