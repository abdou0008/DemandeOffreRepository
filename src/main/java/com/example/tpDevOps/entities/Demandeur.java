package com.example.tpDevOps.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "professeur")
@Data
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150,nullable = false)
    private String email;
    @Column(length = 150)
    private String password;
    @Column(length = 150,nullable = false)
    private String nom;
    @Column(length = 150,nullable = false)
    private String prenom;
    private int etat;
}
