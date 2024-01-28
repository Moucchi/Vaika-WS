package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.repository.autre.UtilisateurRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.HistoriqueVoitureRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.SerieRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/v1/voitures")
public class VoitureController {


    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Autowired
    VoitureRepo voitureRepo;

    @Autowired
    SerieRepo serieRepo;

    @Autowired
    HistoriqueVoitureRepo historiqueVoitureRepo;


    @PostMapping("/historiques")
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

    @GetMapping
    public List<Voiture> getAll() {
        return voitureRepo.findAll();
    }

    @GetMapping("/{id}")
    public Voiture getById(@PathVariable("id") int id) {
        return voitureRepo.findById(id).get();
    }
}
