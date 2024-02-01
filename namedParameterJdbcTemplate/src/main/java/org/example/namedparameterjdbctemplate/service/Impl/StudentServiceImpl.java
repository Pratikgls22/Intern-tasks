package org.example.namedparameterjdbctemplate.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.namedparameterjdbctemplate.dto.StudentRequestDto;
import org.example.namedparameterjdbctemplate.model.Student;
import org.example.namedparameterjdbctemplate.repositry.StudentDao;
import org.example.namedparameterjdbctemplate.service.StudentService;
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
