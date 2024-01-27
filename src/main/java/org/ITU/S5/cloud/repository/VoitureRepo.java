package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepo extends JpaRepository<Voiture, Integer> {
}
