package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.EmployeeWithColumnTransformerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTestRepository extends JpaRepository<EmployeeWithColumnTransformerEntity, Long>{

	EmployeeWithColumnTransformerEntity findById(Long id);

	EmployeeWithColumnTransformerEntity findByName(String name);


}