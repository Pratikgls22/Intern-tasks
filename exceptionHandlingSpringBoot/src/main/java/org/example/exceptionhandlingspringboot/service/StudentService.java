package org.example.exceptionhandlingspringboot.service;

import org.example.exceptionhandlingspringboot.model.Student;
import org.example.exceptionhandlingspringboot.requestDTO.StudentRequestDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student create(StudentRequestDTO studentRequestDTO);

    List<Student> search();

    Optional<Student> searchId(Long id);

    String delete(Long id);
}
