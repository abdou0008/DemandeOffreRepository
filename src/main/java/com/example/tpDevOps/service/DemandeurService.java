package com.example.tpDevOps.service;

import com.example.tpDevOps.entities.Demandeur;

public interface ProfesseurService {
    Demandeur addProfesseur(Demandeur demandeur);
    Demandeur saveProff(String nom, String prenom, String email, String password, Integer etat);
}
