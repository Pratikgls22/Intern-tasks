package org.example.exceptionhandlingspringboot.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.exceptionhandlingspringboot.exception.StudentNotFoundException;
import org.example.exceptionhandlingspringboot.model.Student;
import org.example.exceptionhandlingspringboot.repositry.StudentDao;
import org.example.exceptionhandlingspringboot.requestDTO.StudentRequestDTO;
import org.example.exceptionhandlingspringboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    @Override
    public Student create(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setPhone(studentRequestDTO.getPhone());
        return studentDao.save(student);
    }

    @Override
    public List<Student> search() {
        return  this.studentDao.findAll();
    }

    @Override
    public Optional<Student> searchId(Long id) {
//        return Optional.ofNullable(this.studentDao.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " is not there in Database")));
        Optional<Student> student;
        try {
             student = this.studentDao.findById(id);
            if (student.isPresent()) {
                student.get();
            } else {
                throw new StudentNotFoundException(("Student with id " + id + " is not there in Database"));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ID format. Please provide a valid Long value.");
        }
        return student;
    }

    @Override
    public String delete(Long id) {
        Optional<Student> student = studentDao.findById(id);
        if (student.isPresent()){
            Student sId = student.get();
            studentDao.delete(sId);
            return "deleted !!";
        }
        else{
            throw new StudentNotFoundException(("Student with id " + id + " is not there in Database"));
        }
    }
}
