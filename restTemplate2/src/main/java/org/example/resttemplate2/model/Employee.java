package org.example.resttemplate2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {
    private Long id;
    private String name;
    private String email;
}
