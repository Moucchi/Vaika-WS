package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.HistoriqueAnnonce;
import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.HistoriqueAnnonceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepo annonceRepo;

    List<Annonce> findByCategorie(int idCategorie) {
        return annonceRepo.findByVoiture_Serie_Categorie_Id(idCategorie);
    }

    List<Annonce> findByMarque(int idMarque) {
        return annonceRepo.findByVoiture_Serie_Model_Marque_Id(idMarque);
    }

    List<Annonce> findByModel(int idModel) {
        return annonceRepo.findByVoiture_Serie_Model_Id(idModel);
    }
}
