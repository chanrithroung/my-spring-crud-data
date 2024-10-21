package com.example.crud.mapper;

import com.example.crud.dto.StudentDTO;
import com.example.crud.model.Student;

public class StudentMapper {
    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDob(dto.getDob());
        student.setAge(dto.getAge());
        return student;
    }

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setDob(student.getDob());
        studentDTO.setAge(student.getAge());

        return studentDTO;
    }

}
