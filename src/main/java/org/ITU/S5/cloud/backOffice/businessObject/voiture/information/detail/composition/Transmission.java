package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition;

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
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @OneToMany(mappedBy = "transmission")
    List<Serie> series;
}