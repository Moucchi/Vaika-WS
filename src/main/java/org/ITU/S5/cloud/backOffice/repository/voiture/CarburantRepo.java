package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.composition.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepo extends JpaRepository<Carburant, Integer> {
}
