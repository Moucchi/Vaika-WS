package org.ITU.S5.cloud.businessObject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDetail;

    @ManyToOne
    @JoinColumn(name = "id_model")
    Model model;

    int annee;

    @ManyToOne
    @JoinColumn(name = "id_transmission")
    Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "id_carburant")
    Carburant carburant;

    double puissance;

    int place;

    double consommantion;

}
