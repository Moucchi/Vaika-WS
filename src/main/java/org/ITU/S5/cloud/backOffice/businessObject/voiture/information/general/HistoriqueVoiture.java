package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.security.user.User;

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
    User utilisateur;

    Timestamp dateAchat;

    double prixAchat;
}
