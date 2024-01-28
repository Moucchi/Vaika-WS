package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.HistoriqueAnnonce;
import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.HistoriqueAnnonceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepo annonceRepo;

    @Transactional
    public void updateAnnonce(Annonce annonce) {
        annonceRepo.save(annonce);
    }

}
