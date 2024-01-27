package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepo extends JpaRepository<Transmission, Integer> {
}
