package com.example.backend_etudiant.service;

import com.example.backend_etudiant.entite.Student;
import com.example.backend_etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;
    public void creer(Student student){

    }

}
