package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepo extends JpaRepository<Marque, Integer> {
}
