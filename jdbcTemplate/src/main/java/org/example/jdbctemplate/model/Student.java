package org.example.jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
    private Long id;
    private String name;
    private String email;
    private String grade;
}
