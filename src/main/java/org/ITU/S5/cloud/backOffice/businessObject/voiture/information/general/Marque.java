package org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @JsonManagedReference
    @OneToMany(mappedBy = "marque")
    List<Model> models;
}