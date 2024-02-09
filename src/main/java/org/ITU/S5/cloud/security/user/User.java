package org.ITU.S5.cloud.security.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    double portefeuille;

    @JsonManagedReference
    @OneToMany(mappedBy = "utilisateur")
    List<HistoriqueVoiture> historiqueVoitures;

    @JsonManagedReference
    @OneToMany(mappedBy = "annonceur")
    List<Annonce> annonces;

    @JsonManagedReference
    @ManyToMany(mappedBy = "followers")
    List<Annonce> favoris;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Voiture> voitures = new LinkedHashSet<>();

    public void addFavoris(Annonce annonce) {
        favoris.add(annonce);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
