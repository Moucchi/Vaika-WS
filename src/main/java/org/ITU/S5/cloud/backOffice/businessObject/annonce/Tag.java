package org.ITU.S5.cloud.backOffice.businessObject.annonce;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reference;

    String nom;

    @JsonManagedReference
    @ManyToMany(mappedBy = "tags")
    List<Annonce> annonces;
}