package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.Moteur;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.Transmission;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Categorie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Model;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_model")
    Model model;

    int annee;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    Categorie categorie; // SUV , 4*4 , Berline , ...

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_moteur")
    Moteur moteur;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_transmission")
    Transmission transmission;

    double puissance;

    int place;

    double consommation;
}