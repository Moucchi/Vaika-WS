package org.ITU.S5.cloud.backOffice.businessObject.annonce;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class HistoriqueAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reference;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_annonce")
    Annonce annonce;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_etat")
    EtatAnnonce etat;

    Timestamp date;
}
