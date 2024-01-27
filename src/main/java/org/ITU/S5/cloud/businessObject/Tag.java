package org.ITU.S5.cloud.businessObject;

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

    @ManyToMany(mappedBy = "tags")
    List<Annonce> annonces;
}