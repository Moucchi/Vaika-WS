package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.HistoriqueEtatAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.Inet4Address;

@Repository
public interface HistoriqueAnnonceRepo extends JpaRepository<HistoriqueEtatAnnonce, Inet4Address> {
}
