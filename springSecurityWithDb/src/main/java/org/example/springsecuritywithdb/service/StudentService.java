package org.example.springsecuritywithdb.service;

import org.example.springsecuritywithdb.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    List<Student> search();
}
