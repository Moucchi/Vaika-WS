package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Categorie;
import org.ITU.S5.cloud.backOffice.repository.voiture.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategorieController {
    @Autowired
    CategorieRepo categorieRepo;

    @PostMapping
    public void addCategorie(@RequestParam("nom") String nom) {
        Categorie temp = new Categorie();
        temp.setNom(nom);

        categorieRepo.save(temp);
    }

    @GetMapping
    public List<Categorie> getCategories() {
        return categorieRepo.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getCategoryById(@PathVariable("id") int id) {
        return categorieRepo.findById(id).get();
    }
}
