package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.Moteur;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.*;
import org.ITU.S5.cloud.backOffice.repository.voiture.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/moteurs")
public class MoteurController {
    @Autowired
    AllumageRepo allumageRepo;

    @Autowired
    CarburantRepo carburantRepo;

    @Autowired
    ConceptionRepo conceptionRepo;

    @Autowired
    CylindreRepo cylindreRepo;

    @Autowired
    MoteurRepo moteurRepo;

    @Autowired
    SerieRepo serieRepo;

    @Autowired
    TempsRepo tempsRepo;

    @Autowired
    TransmissionRepo transmissionRepo;

    @Autowired
    ModelRepo modelRepo;

    @Autowired
    CategorieRepo categorieRepo;

    @PostMapping
    public void addMoteur(@RequestParam("idAllumage") int idAllumage,
                          @RequestParam("idCarburant") int idCarburant,
                          @RequestParam("idConception") int idConception,
                          @RequestParam("idCylindre") int idCylindre,
                          @RequestParam("nombreCylindre") int cylindre,
                          @RequestParam("idTemps") int idTemps
    ) {
        Moteur temp = new Moteur();
        temp.setAllumage(allumageRepo.findById(idAllumage).get());
        temp.setCarburant(carburantRepo.findById(idCarburant).get());
        temp.setConception(conceptionRepo.findById(idConception).get());
        temp.setCylindre(cylindreRepo.findById(idCylindre).get());
        temp.setNombreCylindre(cylindre);
        temp.setTemps(tempsRepo.findById(idTemps).get());

        moteurRepo.save(temp);
    }

    @GetMapping
    public List<Moteur> getAll() {
        return moteurRepo.findAll();
    }

    @GetMapping("/{id}")
    public Moteur getById(@PathVariable("id") int id) {
        return moteurRepo.findById(id).get();
    }

    @PostMapping("/allumages")
    public void addAllumage(@RequestParam("nom") String nom) {
        Allumage temp = new Allumage();
        temp.setNom(nom);

        allumageRepo.save(temp);
    }

    @PostMapping("/carburants")
    public void addCarburant(@RequestParam("nom") String nom) {
        Carburant temp = new Carburant();
        temp.setNom(nom);

        carburantRepo.save(temp);
    }

    @PostMapping("/conceptions")
    public void addConception(@RequestParam("nom") String nom) {
        Conception temp = new Conception();
        temp.setNom(nom);

        conceptionRepo.save(temp);
    }

    @PostMapping("/cylindres")
    public void addCylindre(@RequestParam("disposition") String disposition) {
        Cylindre temp = new Cylindre();
        temp.setDisposition(disposition);

        cylindreRepo.save(temp);
    }

    @PostMapping("/series")
    public void addSerie(@RequestParam("nom") String nom,
                         @RequestParam("annee") int annee,
                         @RequestParam("idCategorie") int idCategorie,
                         @RequestParam("consommation") double consommation,
                         @RequestParam("idModel") int idModel,
                         @RequestParam("idMoteur") int idMoteur,
                         @RequestParam("place") int place,
                         @RequestParam("puissance") double puissance,
                         @RequestParam("idTransmission") int idTransmission
    ) {
        Serie temp = new Serie();
        temp.setNom(nom);
        temp.setAnnee(annee);
        temp.setCategorie(categorieRepo.findById(idCategorie).get());
        temp.setConsommation(consommation);
        temp.setModel(modelRepo.findById(idModel).get());
        temp.setMoteur(moteurRepo.findById(idMoteur).get());
        temp.setPlace(place);
        temp.setPuissance(puissance);
        temp.setTransmission(transmissionRepo.findById(idTransmission).get());

        serieRepo.save(temp);

    }

    @PostMapping("/temps")
    public void addTemps(@RequestParam("nom") String nom) {
        Temps temp = new Temps();
        temp.setNom(nom);

        tempsRepo.save(temp);
    }

    @PostMapping("/transmissions")
    public void addTransmission(@RequestParam("nom") String nom) {
        Transmission temp = new Transmission();
        temp.setNom(nom);

        transmissionRepo.save(temp);
    }
}
