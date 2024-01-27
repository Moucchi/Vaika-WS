package org.ITU.S5.cloud.repository;

import org.ITU.S5.cloud.businessObject.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Integer> {
}
