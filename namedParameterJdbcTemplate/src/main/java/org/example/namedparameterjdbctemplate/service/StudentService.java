package org.example.namedparameterjdbctemplate.service;

import org.example.namedparameterjdbctemplate.dto.StudentRequestDto;
import org.example.namedparameterjdbctemplate.model.Student;

import java.util.List;

public interface StudentService {

    int create(StudentRequestDto studentRequestDto);

    List<Student> search();


    List<Student> searchId(Long id);

    String delete(Long id);

    int update(Long id, StudentRequestDto studentRequestDto);
}
