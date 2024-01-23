package org.example.exceptionhandlingspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.exceptionhandlingspringboot.model.Student;
import org.example.exceptionhandlingspringboot.requestDTO.StudentRequestDTO;
import org.example.exceptionhandlingspringboot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
//  @ResponseStatus(code =  HttpStatus.CREATED)
    public Student create(@RequestBody StudentRequestDTO studentRequestDTO){
        return this.studentService.create(studentRequestDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(){
        List<Student> studentList = this.studentService.search();
        return ResponseEntity.status(HttpStatus.FOUND).body(studentList);
    }

    @GetMapping("/search/{id}")
    public Optional<Student> searchId(@PathVariable Long id){
        return this.studentService.searchId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return this.studentService.delete(id);
    }
}
