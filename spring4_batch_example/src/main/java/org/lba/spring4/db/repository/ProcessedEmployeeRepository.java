package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.ProcessedEmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedEmployeeRepository extends JpaRepository<ProcessedEmployeeModel, Long>{

	ProcessedEmployeeModel findById(Long id);

	ProcessedEmployeeModel findByName(String name);


}