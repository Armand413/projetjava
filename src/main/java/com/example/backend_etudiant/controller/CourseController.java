package com.example.backend_etudiant.controller;

import com.example.backend_etudiant.entite.Course;
import com.example.backend_etudiant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // READ all
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // READ by id
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // UPDATE
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}