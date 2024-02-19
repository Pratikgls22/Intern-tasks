package org.example.jwtspringsecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.jwtspringsecurity.dto.UserDto;
import org.example.jwtspringsecurity.model.User;
import org.example.jwtspringsecurity.requestDto.UserRequestDto;
import org.example.jwtspringsecurity.service.JwtService;
import org.example.jwtspringsecurity.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/add")
    @Operation(summary = "Used to Update Data into Database", description =
            "-Name is required " +
                    "- email should contain@  " +
                    "- Password must be 6  " +
                    "- Role should in capital ex:'ROLE_USER'"
    )
    public User create(@Valid @RequestBody UserDto userDto) {
        return this.userService.create(userDto);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<User> search() {
        return this.userService.search();
    }

    @GetMapping("/search/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Optional<User> searchId(@PathVariable Long id) {
        return this.userService.searchId(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public User update(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return this.userService.update(id, userDto);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public User delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    // For Authentication
    @PostMapping("/auth")
    public String authenticationAndGetToken(@RequestBody UserRequestDto requestDto){
        return jwtService.generateToken(requestDto.getUsername());
    }


}
