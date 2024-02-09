package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.SerieRepo;
import org.ITU.S5.cloud.backOffice.repository.voiture.VoitureRepo;
import org.ITU.S5.cloud.security.user.User;
import org.ITU.S5.cloud.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    VoitureRepo voitureRepo;

    @Autowired
    AnnonceRepo annonceRepo;

    @Autowired
    SerieRepo serieRepo;

    List<Annonce> findByCategorie(int idCategorie) {
        return annonceRepo.findByVoiture_Serie_Categorie_Id(idCategorie);
    }

    List<Annonce> findByMarque(int idMarque) {
        return annonceRepo.findByVoiture_Serie_Model_Marque_Id(idMarque);
    }

    List<Annonce> findByModel(int idModel) {
        return annonceRepo.findByVoiture_Serie_Model_Id(idModel);
    }

    void saveAnnonce(String immatriculation,
                     int idSerie,
                     int anneeCirculation,
                     double kilometrage,
                     int nombrePlace,
                     int userId,
                     double prix) {
        Voiture temp = voitureRepo.findById(immatriculation).get();
        User user = userRepository.findById(userId).get();

        if(temp == null) {
            temp = new Voiture();
            temp.setImmatriculation(immatriculation);
            temp.setSerie(serieRepo.findById(idSerie).get());
        }else {
            if (temp.getUser() == null || temp.getUser().getId() == userId ){
                temp.setUser(user);
                voitureRepo.save(temp);
            }else {
                throw new RuntimeException("Vous ne vous appartient pas");
            }
        }

    }
}
