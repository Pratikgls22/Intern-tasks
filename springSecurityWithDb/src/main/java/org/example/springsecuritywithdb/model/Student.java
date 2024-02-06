package org.example.springsecuritywithdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String password;
    private String email;
    private String role;


}
