package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @ManyToOne
    @JoinColumn(name = "id_marque")
    Marque marque;

    @OneToMany(mappedBy = "model")
    List<Serie> series;

}
