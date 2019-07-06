package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeDBModel, Long>{

	EmployeeDBModel findById(Long id);

	EmployeeDBModel findByName(String name);

}

