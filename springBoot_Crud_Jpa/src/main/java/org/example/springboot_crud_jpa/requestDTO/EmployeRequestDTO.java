package org.example.springboot_crud_jpa.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeRequestDTO {
    private String name;
    private int salary;
    private String city;
}
