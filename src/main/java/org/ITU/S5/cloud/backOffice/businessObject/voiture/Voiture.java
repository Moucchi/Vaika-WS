package org.ITU.S5.cloud.backOffice.businessObject.voiture;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;

import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Voiture {
    @Id
    String immatriculation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_serie")
    Serie serie;

    int anneeMiseEnCirculation;

    double kilometrage;

    String couleur; // code hexadecimal

    @JsonManagedReference
    @OneToMany(mappedBy = "voiture", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<HistoriqueVoiture> historiqueVoitures = new LinkedHashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "voiture")
    List<Annonce> annonces;

//    public Map<LocalDate, Double> getEvolutionPrix() {
//        List<HistoriqueVoiture> historique = this.getHistoriqueVoitures();
//        historique.sort(Comparator.comparing(HistoriqueVoiture::getDateAchat));
//
//        Map<LocalDate, Double> statistiques = new LinkedHashMap<>();
//        LocalDate dateDebut = historique.get(0).getDateAchat().toLocalDateTime().toLocalDate();
//        LocalDate dateFin = LocalDate.now();
//        long nombreDeJours = ChronoUnit.DAYS.between(dateDebut, dateFin);
//
//        double dernierPrix = historique.get(0).getPrixAchat();
//        int indexHistorique = 0;
//
//        for (int i = 0; i <= nombreDeJours; i++) {
//            LocalDate dateCourante = dateDebut.plusDays(i);
//
//            if (indexHistorique < historique.size() && historique.get(indexHistorique).getDateAchat().toLocalDateTime().toLocalDate().isEqual(dateCourante)) {
//                dernierPrix = historique.get(indexHistorique).getPrixAchat();
//                indexHistorique++;
//            }
//
//            statistiques.put(dateCourante, dernierPrix);
//        }
//
//        return statistiques;
//    }
}
