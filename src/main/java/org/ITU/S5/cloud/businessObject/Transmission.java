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
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    @OneToMany(mappedBy = "transmission")
    List<DetailModel> detailModels;
}
