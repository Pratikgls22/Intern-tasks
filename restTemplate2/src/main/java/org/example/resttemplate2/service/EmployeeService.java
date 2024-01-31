package org.example.resttemplate2.service;

import org.example.resttemplate2.model.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    String allEmployee();

    ResponseEntity<Employee> create(Employee employee);

    ResponseEntity<Employee> searchId(Long id);

    ResponseEntity<Employee> delete(Long id);

    ResponseEntity<Employee> update(Long id, Employee employee);
}
