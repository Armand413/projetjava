package com.example.backend_etudiant.service;

import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(Math.toIntExact(id));
        return student.orElse(null);
    }


    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(Math.toIntExact(id));

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            return studentRepository.save(student);
        }

        return null;
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(Math.toIntExact(id));
    }
}