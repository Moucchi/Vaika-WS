package org.ITU.S5.cloud.backOffice.businessObject.annonce;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "etat")
    List<Annonce> annonces;

    @JsonManagedReference
    @OneToMany(mappedBy = "etat")
    List<HistoriqueAnnonce> historiqueAnnonces;
}
