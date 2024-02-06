package org.example.springsecuritywithdb.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritywithdb.model.Student;
import org.example.springsecuritywithdb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/serach")
    public List<Student> search() {
        return studentService.search();
    }

}
