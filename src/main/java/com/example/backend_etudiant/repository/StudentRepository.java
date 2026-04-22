package com.example.backend_etudiant.repository;

import com.example.backend_etudiant.entite.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
