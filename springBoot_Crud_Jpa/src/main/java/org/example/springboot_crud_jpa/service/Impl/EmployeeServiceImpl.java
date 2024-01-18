package org.example.springboot_crud_jpa.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.springboot_crud_jpa.entity.Emp;
import org.example.springboot_crud_jpa.repo.EmpDao;
import org.example.springboot_crud_jpa.requestDTO.EmployeRequestDTO;
import org.example.springboot_crud_jpa.service.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeService {
    private final EmpDao empDao;
    @Override
    public String add(EmployeRequestDTO employeRequestDTO) {
        Emp emp = new Emp();
        emp.setName(employeRequestDTO.getName());
        emp.setSalary(employeRequestDTO.getSalary());
        emp.setCity(employeRequestDTO.getCity());
        empDao.save(emp);
        return "Added !";
    }

    @Override
    public List<Emp> search() {
        return  this.empDao.findAll();
    }

    public Optional<Emp> getEmpId(long id) {
        return  this.empDao.findById(id);
    }

    @Override
    public String deleteEmp(long id) {
        Emp emp  = new Emp();
        emp.setEmpId(id);
        this.empDao.delete(emp);

        return "ftyt";
    }

    @Override
    public String update(long id, EmployeRequestDTO employeRequestDTO) {
        Emp emp = this.empDao.findById(id)
                .orElseThrow(()->new RuntimeException("error"));
        emp.setName(employeRequestDTO.getName());
        emp.setSalary(employeRequestDTO.getSalary());
        emp.setCity(employeRequestDTO.getCity());
        this.empDao.save(emp);
        return "update successfully";

//        Optional<Emp>  emp = this.empDao.findById(id);
//        if(emp.isPresent()){
//            emp.get().setName(employeRequestDTO.getName());
//            emp.get().setSalary(employeRequestDTO.getSalary());
//            emp.get().setCity(employeRequestDTO.getCity());
//
//            this.empDao.save(emp.get());
//            return "updated";
//        }
//        else {
//            return  null;
//        }
    }
}
