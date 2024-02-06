package org.example.springsecuritywithdb.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritywithdb.model.Student;
import org.example.springsecuritywithdb.repositry.StudentDao;
import org.example.springsecuritywithdb.service.StudentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final PasswordEncoder passwordEncoder;
    private final StudentDao studentDao;
    @Override
    public Student create(Student student) {

        return studentDao.save(student);
    }

    @Override
    public List<Student> search() {
        return studentDao.findAll();
    }
}
