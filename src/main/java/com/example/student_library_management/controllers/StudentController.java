package com.example.student_library_management.controllers;

import com.example.student_library_management.models.Student;
import com.example.student_library_management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/create_student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam int studentId){
        return studentService.deleteStudent(studentId);
    }
}
