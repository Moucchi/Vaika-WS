package org.ITU.S5.cloud.backOffice.businessObject.annonce;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class EtatAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reference;

    String valeurString;

    int valeurNumerique;

    @OneToMany(mappedBy = "etat")
    List<Annonce> annonces;
}
