package org.example.jwtspringsecurity.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDto {
    private String username;
    private String password;
}
