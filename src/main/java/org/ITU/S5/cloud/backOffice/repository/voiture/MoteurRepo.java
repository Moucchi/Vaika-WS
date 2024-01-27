package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Moteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoteurRepo extends JpaRepository<Moteur , Integer> {
}
