package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.EtatAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatAnnonceRepo extends JpaRepository<EtatAnnonce, Integer> {
}
