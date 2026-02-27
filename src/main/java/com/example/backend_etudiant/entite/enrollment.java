package com.example.backend_etudiant.entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToMany(fetch = FetchType.EAGER)
    private String student_id;
    @ManyToMany(fetch = FetchType.EAGER)
    private String course_id;
}
