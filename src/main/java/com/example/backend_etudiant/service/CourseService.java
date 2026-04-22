package com.example.backend_etudiant.service;

import com.example.backend_etudiant.entite.Course;
import com.example.backend_etudiant.repository.CourseRepository;
import com.example.backend_etudiant.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // CREATE
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // READ all
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // READ by id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + id));
    }

    // UPDATE
    public Course updateCourse(Long id, Course updatedCourse) {
        Course course = getCourseById(id);
        course.setTitle(updatedCourse.getTitle());
        course.setDescription(updatedCourse.getDescription());
        course.setCredit(updatedCourse.getCredit());
        return courseRepository.save(course);
    }

    // DELETE
   // public void deleteCourse(Long id) {
    //    courseRepository.deleteById(id);
   // }
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public void deleteCourse(Long id) {
        enrollmentRepository.deleteByCourseId(id);
        courseRepository.deleteById(id);
    }
}