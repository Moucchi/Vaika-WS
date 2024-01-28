package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepo extends JpaRepository<Transmission, Integer> {
}
