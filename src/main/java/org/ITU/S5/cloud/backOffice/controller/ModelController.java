package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Model;
import org.ITU.S5.cloud.backOffice.repository.voiture.MarqueRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/models")
public class ModelController {
    @Autowired
    ModelRepo modelRepo;

    @Autowired
    MarqueRepo marqueRepo;

    @PostMapping
    public void addModel(@RequestParam("nom") String nom, @RequestParam("idMarque") int idMarque) {
        Model temp = new Model();
        temp.setNom(nom);
        temp.setMarque(marqueRepo.findById(idMarque).get());

        modelRepo.save(temp);
    }

    @GetMapping
    public List<Model> getModels() {
        return modelRepo.findAll();
    }

    @GetMapping("/{id}")
    public Model getModelById( @PathVariable("id") int id) {
        return modelRepo.findById(id).get();
    }
}
