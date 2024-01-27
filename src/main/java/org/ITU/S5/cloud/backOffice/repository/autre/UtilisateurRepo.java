package org.ITU.S5.cloud.backOffice.repository.autre;

import org.ITU.S5.cloud.backOffice.businessObject.acteur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
}
