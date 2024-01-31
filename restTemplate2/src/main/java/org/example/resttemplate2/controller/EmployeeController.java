package org.example.resttemplate2.controller;

import lombok.RequiredArgsConstructor;
import org.example.resttemplate2.model.Employee;
import org.example.resttemplate2.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping("/search")
    public String getAllEmployee() {
        return employeeService.allEmployee();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Employee> searchId(@PathVariable Long id){
        return employeeService.searchId(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        return  employeeService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee){
        return  employeeService.update(id,employee);
    }
}
