package org.example.swaggeruispringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    @NotEmpty(message = "Your Username is empty !!")
    @NotNull(message = "Your Username is Null !!")
    private String username;

    @NotEmpty(message = "Your Email is empty !!")
    @NotNull(message = "Your Email is Null !!")
    @Email
    private String email;

    @NotEmpty(message = "Your password is empty !!")
    @NotNull(message = "Your password is Null !!")
    private String password;

    @NotEmpty(message = "Your role is empty !!")
    @NotNull(message = "Your role is Null !!")
    private String role;
}
