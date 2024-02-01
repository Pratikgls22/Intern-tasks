package org.example.jdbctemplate.controller;

import lombok.RequiredArgsConstructor;
import org.example.jdbctemplate.dto.StudentRequestDto;
import org.example.jdbctemplate.model.Student;
import org.example.jdbctemplate.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jdbcT")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public int create(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.create(studentRequestDto);
    }

    @GetMapping("/search")
    public List<Student> search(){
        return studentService.search();
    }

    @GetMapping("/search/{id}")
    public List<Student> searchId(@PathVariable Long id){
        return studentService.searchId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto){
        return  studentService.update(id,studentRequestDto);
    }
}
