package com.example.backend_etudiant.controller;

import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // creer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    // lire tout
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    // lire par ID
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // modifier
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // supprimer
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}