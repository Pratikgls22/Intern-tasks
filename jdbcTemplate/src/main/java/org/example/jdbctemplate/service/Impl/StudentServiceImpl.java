package org.example.jdbctemplate.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.jdbctemplate.dto.StudentRequestDto;
import org.example.jdbctemplate.model.Student;
import org.example.jdbctemplate.repositry.StudentDao;
import org.example.jdbctemplate.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Override
    public int create(StudentRequestDto studentRequestDto) {
        return studentDao.save(studentRequestDto);
    }

    @Override
    public List<Student> search() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> searchId(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public String delete(Long id) {
        return studentDao.deleteById(id);
    }

    @Override
    public int update(Long id, StudentRequestDto studentRequestDto) {
        return  studentDao.save(id,studentRequestDto);
    }
}
