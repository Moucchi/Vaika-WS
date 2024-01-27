package org.ITU.S5.cloud.backOffice.repository.voiture;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepo extends JpaRepository<Serie, Integer> {
}
