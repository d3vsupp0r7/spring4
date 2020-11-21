package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.relationship.manytomany.unidirectional.AddressM2MUnidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressM2MUnidirectionalRepository extends JpaRepository<AddressM2MUnidirectional, Long>{

	AddressM2MUnidirectional findById(Long id);

	AddressM2MUnidirectional findByName(String name);

}
