package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findById(Long id);

	Employee findByName(String name);


}