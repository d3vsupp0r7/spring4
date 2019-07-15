package org.lba.spring4.repository;

import org.lba.spring4.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer>{

}
