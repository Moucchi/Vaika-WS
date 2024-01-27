package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.EtatAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatAnnonceRepo extends JpaRepository<EtatAnnonce, Integer> {
}
