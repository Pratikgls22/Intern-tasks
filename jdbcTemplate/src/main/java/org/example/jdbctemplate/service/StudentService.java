package org.example.jdbctemplate.service;

import org.example.jdbctemplate.dto.StudentRequestDto;
import org.example.jdbctemplate.model.Student;

import java.util.List;

public interface StudentService {

    int create(StudentRequestDto studentRequestDto);

    List<Student> search();


    List<Student> searchId(Long id);

    String delete(Long id);

    int update(Long id, StudentRequestDto studentRequestDto);
}
