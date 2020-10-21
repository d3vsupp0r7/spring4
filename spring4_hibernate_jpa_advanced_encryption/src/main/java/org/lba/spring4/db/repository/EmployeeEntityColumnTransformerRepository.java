package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.EmployeeEncriptedWithConvertAnnotationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityColumnTransformerRepository extends JpaRepository<EmployeeEncriptedWithConvertAnnotationEntity, Long>{

	EmployeeEncriptedWithConvertAnnotationEntity findById(Long id);

	EmployeeEncriptedWithConvertAnnotationEntity findByName(String name);


}