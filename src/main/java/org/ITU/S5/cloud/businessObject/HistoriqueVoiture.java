package org.ITU.S5.cloud.businessObject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class HistoriqueVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    Utilisateur utilisateur;

    Timestamp dateAchat;

    double prixAchat;
}
