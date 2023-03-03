package com.example.tpDevOps.controller;

import com.example.tpDevOps.entities.Demandeur;
import com.example.tpDevOps.repository.DemandeurRepo;
import com.example.tpDevOps.service.DemandeurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProfesseurController {

    private DemandeurRepo demandeurRepo;
    private DemandeurService demandeurService;


    @GetMapping("/listProf")
    public String showPageListProf(Model model) {
        model.addAttribute("ListProf");
        return "professeur/listProf";
        }

    @PostMapping(path = "/addprof")
    public String add(Model model, @Valid Demandeur demandeur, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "professeur/formProf";
        demandeurService.addProfesseur(demandeur);
        return "redirect:/professeur/listProf";
    }
    @GetMapping("/professeur/listProf")
    public String showlistProf(Model model){
        List<Demandeur> ListProf = demandeurRepo.findAll();
        model.addAttribute("ListProf",ListProf);
        return "professeur/listProf";
    }
     @GetMapping("/login")
    public String formProf(Model model){
        model.addAttribute("professeur", new Demandeur());
        return "professeur/formProf";
    }
    @GetMapping("/editProf")
    public String editProf(Model model,Integer id){
        Demandeur demandeur = demandeurRepo.findById(id).orElse(null);
        if (demandeur ==null) throw  new RuntimeException("Professeur introuvable");
        model.addAttribute("professeur", demandeur);
        return "professeur/editProf";
    }
}
