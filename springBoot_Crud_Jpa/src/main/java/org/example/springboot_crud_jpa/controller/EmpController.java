package org.example.springboot_crud_jpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboot_crud_jpa.entity.Emp;
import org.example.springboot_crud_jpa.requestDTO.EmployeRequestDTO;
import org.example.springboot_crud_jpa.service.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/here")
public class EmpController {

    private final EmployeService employeService;

    @PostMapping("/add")
    public String createEmployee(@RequestBody EmployeRequestDTO employeRequestDTO){
        return this.employeService.add(employeRequestDTO);
    }

    @GetMapping("/search")
    public List<Emp> search(){
        return this.employeService.search();
    }

    @GetMapping("/search/{id}")
    public Optional<Emp> getEmp(@PathVariable("id") long id){
        return this.employeService.getEmpId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable long id){
        return  this.employeService.deleteEmp(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable long id,@RequestBody EmployeRequestDTO employeRequestDTO){
        return this.employeService.update(id,employeRequestDTO);
    }
}
