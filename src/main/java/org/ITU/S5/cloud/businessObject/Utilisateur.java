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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nom;

    String email;

    @Column(name = "mot_de_passe")
    String motDePasse;

    double portefeuille;

    @OneToMany(mappedBy = "utilisateur")
    List<HistoriqueVoiture> historiqueVoitures;

    @OneToMany(mappedBy = "annonceur")
    List<Annonce> annonces;

    @ManyToMany(mappedBy = "followers")
    List<Annonce> favoris;
}
