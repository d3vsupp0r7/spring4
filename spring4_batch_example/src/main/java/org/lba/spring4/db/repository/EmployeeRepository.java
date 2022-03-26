package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

	EmployeeModel findById(Long id);

	EmployeeModel findByName(String name);


}