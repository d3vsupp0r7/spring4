package org.lba.spring4.db.repository;

import org.lba.spring4.db.model.EmployeeFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeFullRepository  extends JpaRepository<EmployeeFull, Long>{

	EmployeeFull findById(Long id);

	EmployeeFull findByName(String name);

	@Transactional
	@Modifying
	@Query("update EmployeeFull e set e.name = :name, e.surname = :surname where e.id = :id")
	int updateEmployeeFullById(@Param("id") long id, @Param("name")String name, @Param("surname")String surname);

}

