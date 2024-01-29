package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonManagedReference
    @OneToMany(mappedBy = "moteur")
    List<Serie> series;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_conception")
    Conception conception; // à piston , wankel

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_allumage")
    Allumage allumage; // par etincelle , par compression

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_cylindre")
    Cylindre cylindre; // disposition : vertical , horizontal , en V , en W , opposés

    int nombreCylindre;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_carburant")
    Carburant carburant; // essence , diesel , GPL , électrique , hybride

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_temps")
    Temps temps; // 2 temps , 4 temps , 6 temps
}