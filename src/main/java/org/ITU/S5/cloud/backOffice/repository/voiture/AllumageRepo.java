package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.Allumage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllumageRepo extends JpaRepository<Allumage , Integer> {
}
