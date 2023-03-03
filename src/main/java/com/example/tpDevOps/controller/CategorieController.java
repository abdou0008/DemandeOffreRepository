package com.example.tpDevOps.controller;

import com.example.tpDevOps.entities.Offre;
import com.example.tpDevOps.repository.OffreRepo;
import com.example.tpDevOps.service.OffreService;
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
public class OffreController {

    private OffreRepo offreRepo;
    private OffreService offreService;


    @GetMapping("/listoffre")
    public String showPageListOffre(Model model) {
        model.addAttribute("ListOffre");
        return "offre/listOffre";
        }

    @PostMapping(path = "/addoffre")
    public String add(Model model, @Valid Offre offre, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "offre/formoffre";
        offreService.addOffre(offre);
        return "redirect:/offre/listoffre";
    }
    @GetMapping("/offre/listoffre")
    public String showlistoffre(Model model){
        List<Offre> ListOffre = offreRepo.findAll();
        model.addAttribute("ListOffre",ListOffre);
        return "offre/listOffre";
    }
    @GetMapping("/editoffre")
    public String editOffre(Model model,Integer id){
        Offre offre = offreRepo.findById(id).orElse(null);
        if (offre ==null) throw  new RuntimeException("offre introuvable");
        model.addAttribute("offre", offre);
        return "offre/editoffre";
    }
}
