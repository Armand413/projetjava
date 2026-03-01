package com.example.backend_etudiant.controller;

import com.example.backend_etudiant.entite.Enrollment;
import com.example.backend_etudiant.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{studentId}/{courseId}")
    public Enrollment createEnrollment(@PathVariable Long studentId, @PathVariable Long courseId) {
        return enrollmentService.createEnrollment(studentId, courseId);
    }

    // READ all
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    // READ by id
    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}