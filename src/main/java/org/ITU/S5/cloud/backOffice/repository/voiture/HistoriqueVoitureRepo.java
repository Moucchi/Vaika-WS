package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueVoitureRepo extends JpaRepository<HistoriqueVoiture, Integer> {
}
