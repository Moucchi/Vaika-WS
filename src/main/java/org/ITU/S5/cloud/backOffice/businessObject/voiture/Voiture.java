package org.ITU.S5.cloud.backOffice.businessObject.voiture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.ITU.S5.cloud.backOffice.repository.voiture.HistoriqueVoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_serie")
    Serie serie;

    int anneeMiseEnCirculation;

    double kilometrage;

    String couleur; // code hexadecimal

    @OneToMany(mappedBy = "voiture")
    List<HistoriqueVoiture> historiqueVoitures;

    @OneToMany(mappedBy = "voiture")
    List<Annonce> annonces;

    public Map<LocalDate, Double> getEvolutionPrix() {
        List<HistoriqueVoiture> historique = this.getHistoriqueVoitures();
        historique.sort(Comparator.comparing(HistoriqueVoiture::getDateAchat));

        Map<LocalDate, Double> statistiques = new LinkedHashMap<>();
        LocalDate dateDebut = historique.get(0).getDateAchat().toLocalDateTime().toLocalDate();
        LocalDate dateFin = LocalDate.now();
        long nombreDeJours = ChronoUnit.DAYS.between(dateDebut, dateFin);

        double dernierPrix = historique.get(0).getPrixAchat();
        int indexHistorique = 0;

        for (int i = 0; i <= nombreDeJours; i++) {
            LocalDate dateCourante = dateDebut.plusDays(i);

            if (indexHistorique < historique.size() && historique.get(indexHistorique).getDateAchat().toLocalDateTime().toLocalDate().isEqual(dateCourante)) {
                dernierPrix = historique.get(indexHistorique).getPrixAchat();
                indexHistorique++;
            }

            statistiques.put(dateCourante, dernierPrix);
        }

        return statistiques;
    }
}
