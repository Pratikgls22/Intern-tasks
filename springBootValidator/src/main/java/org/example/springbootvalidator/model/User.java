package org.example.springbootvalidator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank(message = "userName is required")
    @Column(name = "user_name")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "formate of email id xyz@gmail.com")
    @Column(name = "user_email")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8,max = 12)
//    @Pattern(regexp = "[a-z]", message = "useing atleast 1 alphabet")
    @Column(name = "user_password")
    private String password;
}
