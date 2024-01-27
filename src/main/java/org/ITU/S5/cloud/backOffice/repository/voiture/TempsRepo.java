package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition.Temps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempsRepo extends JpaRepository<Temps , Integer> {
}
