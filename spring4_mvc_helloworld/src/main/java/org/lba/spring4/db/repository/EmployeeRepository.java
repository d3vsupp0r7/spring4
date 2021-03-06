package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	Employee findById(Long id);

	Employee findByName(String name);

	@Transactional
	@Modifying
	@Query("update Employee e set e.name = :name, e.surname = :surname where e.id = :id")
	int updateEmployeeById(@Param("id") long id, @Param("name")String name, @Param("surname")String surname);

}

