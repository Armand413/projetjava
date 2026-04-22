package com.example.backend_etudiant.service;

import com.example.backend_etudiant.entite.Course;
import com.example.backend_etudiant.entite.Enrollment;
import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.repository.CourseRepository;
import com.example.backend_etudiant.repository.EnrollmentRepository;
import com.example.backend_etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // CREATE
    public Enrollment createEnrollment(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec id: " + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    // READ all
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // READ by id
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription non trouvée avec id: " + id));
    }

    // DELETE
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}