package org.example.springboot_crud_jpa.service;


import org.example.springboot_crud_jpa.entity.Emp;
import org.example.springboot_crud_jpa.requestDTO.EmployeRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmployeService {
    String add(EmployeRequestDTO employeRequestDTO);


    List<Emp> search();

    Optional<Emp> getEmpId(long id);


    String deleteEmp(long id);

    String update(long id, EmployeRequestDTO employeRequestDTO);
}
