package com.example.tpDevOps.service;

import com.example.tpDevOps.entities.Demandeur;
import com.example.tpDevOps.repository.ProfesseurRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private ProfesseurRepo professeurRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public Demandeur addProfesseur(Demandeur demandeur) {
        return professeurRepo.save(demandeur);
    }

    public Demandeur saveProff(String nom, String prenom, String email, String password, Integer etat) {
       // if (!password.equals(repassword)) throw new RuntimeException("password not match");
        String hashedPWD=passwordEncoder.encode(password);
        Demandeur p =new Demandeur();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setEmail(email);
        p.setEtat(etat);
        p.setPassword(hashedPWD);
        Demandeur savedAppUser= professeurRepo.save(p);
        return savedAppUser;
    }
}
