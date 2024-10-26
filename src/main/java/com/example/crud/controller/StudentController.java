package com.example.crud.controller;

import com.example.crud.CrudApplication;
import com.example.crud.dto.StudentDTO;
import com.example.crud.services.StudentService;
import com.example.crud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }
    
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
    public HashMap<String, Object> getStudent() {
        return studentService.getStudents();
    }



    @PostMapping
    public String postStudent(@RequestBody StudentDTO req) {
        return studentService.createStudent(req);
    }


    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

}
