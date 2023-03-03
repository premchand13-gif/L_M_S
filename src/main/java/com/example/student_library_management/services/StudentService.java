package com.example.student_library_management.services;

import com.example.student_library_management.enums.CardStatus;
import com.example.student_library_management.models.LibraryCard;
import com.example.student_library_management.models.Student;
import com.example.student_library_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String createStudent(Student student){
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardStatus(CardStatus.ACTIVATED);
        libraryCard.setStudentV(student);

        student.setLibraryCard(libraryCard);
        studentRepository.save(student);
        return "Student created successfully";

    }
    public String deleteStudent(int studentId){
        Student student=studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return "deleted successfully";
    }
}
