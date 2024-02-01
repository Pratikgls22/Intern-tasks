package org.example.namedparameterjdbctemplate.repositry;

import org.example.namedparameterjdbctemplate.dto.StudentRequestDto;
import org.example.namedparameterjdbctemplate.model.Student;

import java.util.List;


public interface StudentDao {

    int save(StudentRequestDto studentRequestDto);

    List<Student> findAll();

    List<Student> findById(Long id);

    String deleteById(Long id);

    int save(Long id, StudentRequestDto studentRequestDto);
}
