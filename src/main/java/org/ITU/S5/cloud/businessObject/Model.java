package org.ITU.S5.cloud.businessObject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
            ;
    String nom;

    @ManyToOne
    @JoinColumn(name = "id_marque")
    Marque marque;

    @ManyToOne
    @JoinColumn(name = "id_Carburant")
    Categorie categorie;

    @OneToMany(mappedBy = "model")
    List<DetailModel> detailModels;
}
