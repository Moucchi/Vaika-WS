package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.Moteur;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Carburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @JsonManagedReference
    @OneToMany(mappedBy = "carburant")
    List<Moteur> moteurs;

}
