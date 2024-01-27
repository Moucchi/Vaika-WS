package org.ITU.S5.cloud.backOffice.businessObject.voiture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;

import java.util.List;

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
}
