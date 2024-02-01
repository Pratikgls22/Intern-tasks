package org.example.jdbctemplate.repositry;

import org.example.jdbctemplate.dto.StudentRequestDto;

import org.example.jdbctemplate.model.Student;

import java.util.List;


public interface StudentDao {

    int save(StudentRequestDto studentRequestDto);

    List<Student> findAll();

    List<Student> findById(Long id);

    String deleteById(Long id);

    int save(Long id, StudentRequestDto studentRequestDto);
}
