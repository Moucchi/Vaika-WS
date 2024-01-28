package org.ITU.S5.cloud.backOffice.businessObject.annonce;

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

    @ManyToOne
    @JoinColumn(name = "id_annonce")
    Annonce annonce;

    @ManyToOne
    @JoinColumn(name = "id_etat")
    EtatAnnonce etat;

    Timestamp date;
}
