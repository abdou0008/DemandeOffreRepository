package com.example.tpDevOps.repository;

import com.example.tpDevOps.entities.Demandeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepo extends JpaRepository<Demandeur,Integer> {
}
