package org.example.resttemplate.service;

import org.example.resttemplate.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> search();

    Optional<Employee> searchId(Long id);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
