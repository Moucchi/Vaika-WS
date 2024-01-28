package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.moteur.composant.Cylindre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CylindreRepo extends JpaRepository<Cylindre , Integer> {
}
