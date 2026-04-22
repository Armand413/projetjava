package com.example.backend_etudiant.repository;

import com.example.backend_etudiant.entite.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    void deleteByStudentId(Long studentId);
    void deleteByCourseId(Long courseId);

}