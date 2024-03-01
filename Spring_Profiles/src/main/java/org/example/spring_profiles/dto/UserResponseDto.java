package org.example.spring_profiles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
}
