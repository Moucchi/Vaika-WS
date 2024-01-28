package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.ITU.S5.cloud.backOffice.repository.voiture.MarqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/marques")
public class MarqueController {
    @Autowired
    MarqueRepo marqueRepo;

    @PostMapping
    public void addMarque(@RequestParam("nom") String nom) {
        Marque temp = new Marque();
        temp.setNom(nom);

        marqueRepo.save(temp);
    }

    @GetMapping
    public List<Marque> getAll() {
        return marqueRepo.findAll();
    }

    @GetMapping("/{id}")
    public Marque getById(@PathVariable("id") int id ){
        return marqueRepo.findById(id).get();
    }
}
