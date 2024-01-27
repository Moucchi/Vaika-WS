package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepo extends JpaRepository<Voiture, Integer> {
}
