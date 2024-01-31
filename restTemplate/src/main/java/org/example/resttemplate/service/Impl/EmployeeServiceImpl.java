package org.example.resttemplate.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.resttemplate.enums.CommonEnums;
import org.example.resttemplate.model.Employee;
import org.example.resttemplate.repositry.EmployeeDao;
import org.example.resttemplate.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public Employee create(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> search() {

        log.info("FindAll Calledd ::::::");

        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> searchId(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee employee1 = employeeDao.findById(id).orElseThrow(() -> new RuntimeException(CommonEnums.EXCEPTION_MSG.getMessage()));
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        return employeeDao.save(employee1);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeDao.findById(id).orElseThrow(() -> new RuntimeException(CommonEnums.EXCEPTION_MSG.getMessage()));
        employeeDao.delete(employee);
    }
}
