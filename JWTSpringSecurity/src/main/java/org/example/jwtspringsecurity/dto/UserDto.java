package org.example.jwtspringsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    @NotBlank(message = "name is Blank !!")
    private String name;
    @NotBlank(message = "password is Blank !!")
    private String password;
    @NotBlank(message = "email is Blank !!")
    @Email(message = "Email is not in properFormat - abc@")
    private String email;
    @NotBlank(message = "roles is Blank !!")
    private String roles;
}
