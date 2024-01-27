package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Moteur;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cylindre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String disposition;

    @OneToMany(mappedBy = "cylindre")
    List<Moteur> moteurs;
}
