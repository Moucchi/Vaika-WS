package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepo extends JpaRepository<Annonce , Integer> {
}
