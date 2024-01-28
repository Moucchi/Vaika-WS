package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.EtatAnnonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.HistoriqueAnnonce;
import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.EtatAnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.HistoriqueAnnonceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/annonces")
public class AnnonceController {
    @Autowired
    AnnonceRepo annonceRepo;

    @Autowired
    HistoriqueAnnonceRepo historiqueAnnonceRepo;

    @Autowired
    EtatAnnonceRepo etatAnnonceRepo;

    @PostMapping("/validate")
    public void validateAnnonce(@RequestParam("id") int id) {
        Annonce annonce = annonceRepo.findById(id).get();

        HistoriqueAnnonce historiqueAnnonce = new HistoriqueAnnonce();
        historiqueAnnonce.setAnnonce(annonce);

        EtatAnnonce etatAnnonce = etatAnnonceRepo.findById(2).get();

        annonce.setEtat(etatAnnonce);
        annonceRepo.save(annonce);

        historiqueAnnonce.setEtat(etatAnnonce);
        historiqueAnnonce.setDate(new java.sql.Timestamp(System.currentTimeMillis()));

        historiqueAnnonceRepo.save(historiqueAnnonce);
    }
}
