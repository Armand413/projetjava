package com.example.backend_etudiant.controller;


import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "eutdiant")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Student student){
        this.studentService.creer(student);
    }


}
