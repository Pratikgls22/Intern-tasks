package org.example.resttemplate.controller;

import lombok.RequiredArgsConstructor;
import org.example.resttemplate.model.Employee;
import org.example.resttemplate.repositry.EmployeeDao;
import org.example.resttemplate.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping("/search")
    public List<Employee> search(){
        return employeeService.search();
    }

    @GetMapping("/search/{id}")
    public Optional<Employee> searchId(@PathVariable Long id){
        return employeeService.searchId(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

}
