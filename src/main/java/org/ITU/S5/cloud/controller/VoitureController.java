package org.ITU.S5.cloud.controller;

import org.ITU.S5.cloud.businessObject.*;
import org.ITU.S5.cloud.repository.*;
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
    MarqueRepo marqueRepo;

    @Autowired
    CategorieRepo categorieRepo;

    @Autowired
    CarburantRepo carburantRepo;

    @Autowired
    ModelRepo modelRepo;

    @Autowired
    DetailModelRepo detailModelRepo;

    @Autowired
    HistoriqueVoitureRepo historiqueVoitureRepo;

    @Autowired
    TagRepo tagRepo;

    @Autowired
    TransmissionRepo transmissionRepo;

    @Autowired
    VoitureRepo voitureRepo;

    @Autowired
    UtilisateurRepo utilisateurRepo;

    @PostMapping("/carburant")
    public Carburant saveCarburant(@RequestParam("nom") String nom) {
        Carburant temp = new Carburant();
        temp.setNom(nom);

        return carburantRepo.save(temp);
    }

    @PostMapping("/categorie")
    public Categorie saveCategorie(@RequestParam("nom") String nom) {
        Categorie temp = new Categorie();
        temp.setNom(nom);

        return categorieRepo.save(temp);
    }

    @PostMapping("/detailModel")
    public DetailModel saveDetailModel(@RequestParam("idModel") int idModel,
                                       @RequestParam("annee") int annee,
                                       @RequestParam("idTransmission") int idTransmission,
                                       @RequestParam("idCarburant") int idCarburant,
                                       @RequestParam("puissance") double puissance,
                                       @RequestParam("place") int place,
                                       @RequestParam("consommation") double consommation) {
        Model model = modelRepo.findById(idModel).get();
        Transmission transmission = transmissionRepo.findById(idTransmission).get();
        Carburant carburant = carburantRepo.findById(idCarburant).get();

        DetailModel temp = new DetailModel();
        temp.setModel(model);
        temp.setAnnee(annee);
        temp.setTransmission(transmission);
        temp.setCarburant(carburant);
        temp.setPuissance(puissance);
        temp.setPlace(place);
        temp.setConsommantion(consommation);

        return detailModelRepo.save(temp);
    }

    @PostMapping("/historiqueVoiture")
    public HistoriqueVoiture saveHistoriueVoiture(@RequestParam("idVoiture") int idVoiture,
                                                  @RequestParam("idUtilisateur") int idUtilisateur,
                                                  @RequestParam("date") String date,
                                                  @RequestParam("prix") double prix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOnly = LocalDate.parse(date, formatter);
        LocalDateTime dateTime = dateOnly.atStartOfDay();
        Timestamp dateAchat = Timestamp.valueOf(dateTime);

        Voiture voiture = voitureRepo.findById(idVoiture).get();
        Utilisateur utilisateur = utilisateurRepo.findById(idUtilisateur).get();

        HistoriqueVoiture temp = new HistoriqueVoiture();
        temp.setVoiture(voiture);
        temp.setUtilisateur(utilisateur);
        temp.setDateAchat(dateAchat);
        temp.setPrixAchat(prix);

        return historiqueVoitureRepo.save(temp);
    }

    @PostMapping("/marque")
    public Marque saveMarque(@RequestParam("nom") String nom) {
        Marque temp = new Marque();
        temp.setNom(nom);

        return marqueRepo.save(temp);
    }

    @PostMapping("/model")
    public void saveModel(@RequestParam("nom") String nom,
                           @RequestParam("idMarque") int idMarque,
                           @RequestParam("idCategorie") int idCategorie) {
        Marque marque = marqueRepo.findById(idMarque).get();
        Categorie categorie = categorieRepo.findById(idCategorie).get();

        Model temp = new Model();
        temp.setNom(nom);
        temp.setMarque(marque);
        temp.setCategorie(categorie);

        modelRepo.save(temp);
    }

    @PostMapping("/tag")
    public Tag saveTag(@RequestParam("nom") String nom) {
        Tag temp = new Tag();
        temp.setNom(nom);

        return tagRepo.save(temp);
    }

    @PostMapping("/transmission")
    public Transmission saveTransmission(@RequestParam("nom") String nom) {
        Transmission temp = new Transmission();
        temp.setNom(nom);

        return transmissionRepo.save(temp);
    }

    @PostMapping("/voiture")
    public Voiture saveVoiture(@RequestParam("idDetailModel") int idDetailModel,
                               @RequestParam("annee") int annee,
                               @RequestParam("kilometrage") double kilometrage,
                               @RequestParam("couleur") String couleur) {
        DetailModel detailModel = detailModelRepo.findById(idDetailModel).get();

        Voiture temp = new Voiture();
        temp.setDetailModel(detailModel);
        temp.setAnneeMiseEnCirculation(annee);
        temp.setKilometrage(kilometrage);
        temp.setCouleur(couleur);

        return voitureRepo.save(temp);
    }
}
