package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.EmployeeFull;

public interface EmployeeFullService {

	//C
	public EmployeeFull saveEmployee(EmployeeFull employee);

	//R
	public List<EmployeeFull> listAllEmployees();
	public EmployeeFull findById(long id);

	//U
	public int updateEmployeeById(long id, EmployeeFull employee);
	
	//D
	public void deleteEmployeeById(long id);



	
}
