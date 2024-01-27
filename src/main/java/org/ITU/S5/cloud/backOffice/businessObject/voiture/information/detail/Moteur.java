package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "moteur")
    List<Serie> series;

    @ManyToOne
    @JoinColumn(name = "id_conception")
    Conception conception; // à piston , wankel

    @ManyToOne
    @JoinColumn(name = "id_allumage")
    Allumage allumage; // par etincelle , par compression

    @ManyToOne
    @JoinColumn(name = "id_cylindre")
    Cylindre cylindre; // disposition : vertical , horizontal , en V , en W , opposés

    int nombreCylindre;

    @ManyToOne
    @JoinColumn(name = "id_carburant")
    Carburant carburant; // essence , diesel , GPL , électrique , hybride

    @ManyToOne
    @JoinColumn(name = "id_temps")
    Temps temps; // 2 temps , 4 temps , 6 temps
}
