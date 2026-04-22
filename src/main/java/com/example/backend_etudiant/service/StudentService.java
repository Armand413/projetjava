package com.example.backend_etudiant.service;

import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.repository.EnrollmentRepository;
import com.example.backend_etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student newStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            return studentRepository.save(student);
        }).orElse(null);
    }

    public void deleteStudent(Long id) {
        enrollmentRepository.deleteByStudentId(id);
        studentRepository.deleteById(id);
    }

}