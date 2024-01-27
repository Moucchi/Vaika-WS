package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Integer> {
}
