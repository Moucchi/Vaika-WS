package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Integer> {
}
