package org.ITU.S5.cloud.businessObject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "id_detail_model")
    DetailModel detailModel;

    int anneeMiseEnCirculation;

    double kilometrage;

    String couleur; // code hexadecimal

    @OneToMany(mappedBy = "voiture")
    List<HistoriqueVoiture> historiqueVoitures;

    @OneToMany(mappedBy = "voiture")
    List<Annonce> annonces;
}
