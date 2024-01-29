package org.ITU.S5.cloud.backOffice.controller;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.EtatAnnonce;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.HistoriqueAnnonce;
import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.EtatAnnonceRepo;
import org.ITU.S5.cloud.backOffice.repository.annonce.HistoriqueAnnonceRepo;
import org.ITU.S5.cloud.security.user.User;
import org.ITU.S5.cloud.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/annonces")
public class AnnonceController {
    @Autowired
    AnnonceRepo annonceRepo;

    @Autowired
    HistoriqueAnnonceRepo historiqueAnnonceRepo;

    @Autowired
    EtatAnnonceRepo etatAnnonceRepo;

    @Autowired
    UserRepository userRepository;

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

    //    Voir liste/fiche des annonces (sans login)
    @GetMapping
    public List<Annonce> getAll() {
        return annonceRepo.findAll();
    }

    //    Voir l’historique de ses annonces
    @GetMapping("/myHostory")
    public HashMap<Annonce, List<HistoriqueAnnonce>> getHistoriqueAnnonce(@RequestParam("userId")int userId) {
        List<Annonce> annonces = annonceRepo.findByAnnonceur_Id(userId);
        HashMap<Annonce, List<HistoriqueAnnonce>> historiqueAnnonce = new HashMap<>();

        for (Annonce annonce : annonces) {
            historiqueAnnonce.put(annonce, annonce.getHistoriqueAnnonces());
        }

        return historiqueAnnonce;
    }

    //    Mettre des annonces en favoris, liste des favoris
    @PostMapping("/addFavoris")
    public void addFavoris(@RequestParam("userId")int userId,@RequestParam("idAnnonce") int annonceId) {
        Annonce annonce = annonceRepo.findById(annonceId).get();
        User user = userRepository.findById(userId).get();

        user.addFavoris(annonce);
        annonce.addFollower(user);

        userRepository.save(user);
        annonceRepo.save(annonce);
    }

    //    Voir la liste de ses annonces et leur statuts
    @GetMapping("/myAnnonces")
    public List<Annonce> getMyAnnonces(@RequestParam("userId") int userId) {
        return annonceRepo.findByAnnonceur_Id(userId);
    }

    //    Modification statut annonce
    @PutMapping
    public void editAnnonceStatus( @RequestParam("idAnnonce") int idAnnonce,@RequestParam("idEtat") int idStatus) {
        Annonce annonce = annonceRepo.findById(idAnnonce).get();
        EtatAnnonce etatAnnonce = etatAnnonceRepo.findById(idStatus).get();

        HistoriqueAnnonce historiqueAnnonce = new HistoriqueAnnonce();
        historiqueAnnonce.setAnnonce(annonce);
        historiqueAnnonce.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        historiqueAnnonce.setEtat(etatAnnonce);

        annonce.setEtat(etatAnnonce);
        annonceRepo.save(annonce);
        historiqueAnnonceRepo.save(historiqueAnnonce);
    }
}
