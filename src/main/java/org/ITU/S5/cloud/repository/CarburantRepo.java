package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepo extends JpaRepository<Carburant, Integer> {
}
