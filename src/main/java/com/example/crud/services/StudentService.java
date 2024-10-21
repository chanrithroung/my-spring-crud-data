package com.example.crud.services;
import com.example.crud.dto.StudentDTO;
import com.example.crud.mapper.StudentMapper;
import com.example.crud.repository.StudentRepository;
import com.example.crud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@Component
@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;


    public HashMap<String, Object> getStudents() {
        List<Student> students = studentRepository.findAll();
        HashMap<String, Object> studentMap = new HashMap<String, Object>();

        studentMap.put("status", HttpStatus.OK);
        studentMap.put("message", "request success");
        studentMap.put("payload", students);

        return studentMap;
    }


    public String createStudent(StudentDTO request) {
        Student student = StudentMapper.toEntity(request);
        studentRepository.save(student);
        return "Student created successfully!";
    }


    // Get student by id
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }


    // Update Student
    public Student updateStudent(String id, StudentDTO studentDTO) {
        //
        Student updateStudent = StudentMapper.toEntity(studentDTO);
        Optional<Student> existingStudentOpt = studentRepository.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();

            existingStudent.setName(updateStudent.getName());
            existingStudent.setEmail(updateStudent.getEmail());
            existingStudent.setDob(updateStudent.getDob());
            existingStudent.setAge(updateStudent.getAge());

            return studentRepository.save(existingStudent);
        }

        throw new RuntimeException("Student not found with id : " + id);

    }



}
