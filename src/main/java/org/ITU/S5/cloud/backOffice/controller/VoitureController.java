package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Moteur;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition.*;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Categorie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Model;
import org.ITU.S5.cloud.backOffice.repository.autre.UtilisateurRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/voiture")
public class VoitureController {
    @Autowired
    AllumageRepo allumageRepo;

    @Autowired
    ConceptionRepo conceptionRepo;

    @Autowired
    MarqueRepo marqueRepo;

    @Autowired
    CarburantRepo carburantRepo;

    @Autowired
    TempsRepo tempsRepo;

    @Autowired
    CylindreRepo cylindreRepo;

    @Autowired
    TransmissionRepo transmissionRepo;

    @Autowired
    ModelRepo modelRepo;

    @Autowired
    MoteurRepo moteurRepo;

    @Autowired
    CategorieRepo categorieRepo;

    @Autowired
    SerieRepo serieRepo;

    @Autowired
    VoitureRepo voitureRepo;

    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Autowired
    HistoriqueVoitureRepo historiqueVoitureRepo;

    @PostMapping("/allumage")
    public void addAllumage(@RequestParam("nom") String nom) {
        Allumage temp = new Allumage();
        temp.setNom(nom);

        allumageRepo.save(temp);
    }

    @PostMapping("/carburant")
    public void addCarburant(@RequestParam("nom") String nom) {
        Carburant temp = new Carburant();
        temp.setNom(nom);

        carburantRepo.save(temp);
    }

    @PostMapping("/conception")
    public void addConception(@RequestParam("nom") String nom) {
        Conception temp = new Conception();
        temp.setNom(nom);

        conceptionRepo.save(temp);
    }

    @PostMapping("/marque")
    public void addMarque(@RequestParam("nom") String nom) {
        Marque temp = new Marque();
        temp.setNom(nom);

        marqueRepo.save(temp);
    }

    @PostMapping("/cylindre")
    public void addCylindre(@RequestParam("disposition") String disposition) {
        Cylindre temp = new Cylindre();
        temp.setDisposition(disposition);

        cylindreRepo.save(temp);
    }

    @PostMapping("/temps")
    public void addTemps(@RequestParam("nom") String nom) {
        Temps temp = new Temps();
        temp.setNom(nom);

        tempsRepo.save(temp);
    }

    @PostMapping("/transmission")
    public void addTransmission(@RequestParam("nom") String nom) {
        Transmission temp = new Transmission();
        temp.setNom(nom);

        transmissionRepo.save(temp);
    }

    @PostMapping("/moteur")
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

    @PostMapping("/serie")
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

    @PostMapping("/categorie")
    public void addCategorie(@RequestParam("nom") String nom) {
        Categorie temp = new Categorie();
        temp.setNom(nom);

        categorieRepo.save(temp);
    }

    @PostMapping("/historique")
    public void addHistorique(@RequestParam("date") String date,
                              @RequestParam("prix") double prixAchat,
                              @RequestParam("idAcheteur") int idAcheteur,
                              @RequestParam("idVoiture") int idVoiture
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOnly = LocalDate.parse(date, formatter);
        LocalDateTime dateTime = dateOnly.atStartOfDay();
        Timestamp dateTimestamp = Timestamp.valueOf(dateTime);

        HistoriqueVoiture temp = new HistoriqueVoiture();
        temp.setDateAchat(dateTimestamp);
        temp.setPrixAchat(prixAchat);
        temp.setUtilisateur(utilisateurRepo.findById(idAcheteur).get());
        temp.setVoiture(voitureRepo.findById(idVoiture).get());

        historiqueVoitureRepo.save(temp);
    }

    @PostMapping("/model")
    public void addModel(@RequestParam("nom") String nom,
                         @RequestParam("idMarque") int idMarque
    ) {
        Model temp = new Model();
        temp.setNom(nom);
        temp.setMarque(marqueRepo.findById(idMarque).get());

        modelRepo.save(temp);
    }

    @PostMapping
    public void addVoiture(@RequestParam("anneeCirculation") int anneeCirculation,
                           @RequestParam("couleur") String couleur,
                           @RequestParam("kilometrage") double kilometrage,
                           @RequestParam("idSerie") int idSerie
    ) {
        Voiture temp = new Voiture();
        temp.setAnneeMiseEnCirculation(anneeCirculation);
        temp.setCouleur(couleur);
        temp.setKilometrage(kilometrage);
        temp.setSerie(serieRepo.findById(idSerie).get());

        voitureRepo.save(temp);
    }
}
