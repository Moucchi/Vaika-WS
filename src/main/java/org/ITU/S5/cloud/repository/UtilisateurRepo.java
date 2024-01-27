package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
}
