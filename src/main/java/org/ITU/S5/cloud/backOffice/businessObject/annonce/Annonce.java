package org.ITU.S5.cloud.backOffice.businessObject.annonce;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.security.user.User;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_voiture")
    Voiture voiture;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    User annonceur;

    double prix;

    Timestamp datePublication;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_etat")
    EtatAnnonce etat;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "favoris",
            joinColumns = @JoinColumn(name = "id_annonce"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur")
    )
    List<User> followers;

    public void addFollower(User user) {
        followers.add(user);
    }

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "annonce_tag",
            joinColumns = @JoinColumn(name = "id_annonce"),
            inverseJoinColumns = @JoinColumn(name = "id_tag")
    )
    List<Tag> tags;

    @JsonManagedReference
    @OneToMany(mappedBy = "annonce")
    List<HistoriqueEtatAnnonce> historiqueEtatAnnonces;
}
