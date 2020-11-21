package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.relationship.manytomany.unidirectional.EmployeeM2MUnidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeM2MUnidirectionalRepository extends JpaRepository<EmployeeM2MUnidirectional, Long>{

	EmployeeM2MUnidirectional findById(Long id);

	EmployeeM2MUnidirectional findByName(String name);


}