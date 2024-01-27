package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepo extends JpaRepository<Annonce , Integer> {
}
